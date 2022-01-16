plugins {
    id("fabric-loom") version "0.10-SNAPSHOT"
    id("io.github.juuxel.loom-quiltflower-mini") version "1.2.1"
    id("org.cadixdev.licenser") version "0.6.1"
}

val modVersion: String by project

group = "io.github.jamalam360"
version = modVersion

dependencies {
    val minecraftVersion: String by project
    val mappingsVersion: String by project
    val loaderVersion: String by project

    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$mappingsVersion:v2")
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(
                mutableMapOf(
                    "version" to project.version
                )
            )
        }
    }

    build {
        dependsOn("updateLicenses")
    }

    jar {
        archiveBaseName.set("MoreMessages")
    }

    remapJar {
        archiveBaseName.set("MoreMessages")
    }

    withType<JavaCompile> {
        options.release.set(17)
    }
}


