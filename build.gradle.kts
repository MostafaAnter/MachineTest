// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath (AppDependencies.tool_gradle)
        classpath (AppDependencies.kotlin_gradle_plugin)
        // for check dependencies updates
        classpath (AppDependencies.tools_gradle_versions)

        // for google services
        classpath (AppDependencies.google_services)

        // for crashlytics
        classpath (AppDependencies.crashlytics)

        // for dagger hilt
        classpath (AppDependencies.dagger_class)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

//detekt code analysis
plugins {
    this.id(Versions.detekt_ID).version(Versions.detekt_version)
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}