pluginManagement {
    repositories {
        maven(url = "https://maven.quiltmc.org/repository/release") {
            name = "Quilt"
        }
        maven(url = "https://maven.fabricmc.net") {
            name = "Fabric"
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "qubed"

