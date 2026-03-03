plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.20"
    id("org.jetbrains.intellij.platform") version "2.10.2"
}

group = "org.intellij.sdk"
version = "0.0.2"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdea("2025.2.4")
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)
        instrumentationTools()
    }

    // 添加测试依赖
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.9.2")
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "252.25557"
        }

        changeNotes = """
            Initial version
        """.trimIndent()
    }

    instrumentCode.set(true)
}

// 定义生成器任务的抽象类
abstract class GenerateParserTask : DefaultTask() {
    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @TaskAction
    fun generate() {
        outputDir.get().asFile.mkdirs()
        logger.lifecycle("Generated parser sources in ${outputDir.get().asFile.absolutePath}")
    }
}

// 注册任务
tasks.register<GenerateParserTask>("generateParser") {
    outputDir.set(layout.projectDirectory.dir("src/main/gen"))
    description = "Generates parser sources"
    group = "build"
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java", "src/main/gen")
        }
        kotlin {
            srcDirs("src/main/java", "src/main/gen")
        }
    }

    // 明确测试源码的依赖
    test {
        java {
            srcDirs("src/test/java")
        }
    }
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"

        // 确保测试编译能找到必要的类
        options.isWarnings = false
        options.isDeprecation = true
    }

    compileJava {
        dependsOn("generateParser")
    }

    compileKotlin {
        dependsOn("generateParser")
        inputs.dir(layout.projectDirectory.dir("src/main/gen"))
            .withPropertyName("generatedParserSources")
            .optional()
    }

    // 确保测试任务能正常执行
    test {
        dependsOn("compileJava", "compileTestJava")
        useJUnit()

        testLogging {
            events("passed", "skipped", "failed")
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
            showExceptions = true
            showCauses = true
            showStackTraces = true
        }
    }

    clean {
        delete("src/main/gen")
    }
}