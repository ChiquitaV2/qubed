plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.loom)
    java
}

group = project.group
//archivesBaseName = project.name
version = project.version

repositories {
    mavenCentral()
    maven("https://maven.quantumclient.org/snapshots/")
//    maven(url = "https://maven.quiltmc.org/repository/central/") {
//        name = "Quilt central"
//    }
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.layered {
        addLayer(quiltMappings.mappings("org.quiltmc:quilt-mappings:${libs.versions.quilt.mappings.get()}:v2"))
    })
    modImplementation(libs.quilt.loader)
    modImplementation(libs.quilt.stl)

    modImplementation(libs.energy) // not that good but yk quick and dirty

    implementation("com.electronwill.night-config:toml:3.6.5") // 90% sure this is needed bc i'm using qsl and not quilted fabric api

    modImplementation(libs.kotlin.stdlib)
    modImplementation(libs.kotlin.reflect)
}

tasks {

    processResources {
        inputs.property("version", project.version)
        filesMatching("quilt.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }


    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}
