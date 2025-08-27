pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://verve.jfrog.io/artifactory/verve-gradle-release/") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://verve.jfrog.io/artifactory/verve-gradle-release/") }
    }
}
rootProject.name = "HyBidCalculator"
include(":app")