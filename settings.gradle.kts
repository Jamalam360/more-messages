pluginManagement {
    repositories {
        var mavenUrls = listOf(
            "https://maven.fabricmc.net/",
            "https://server.bbkr.space/artifactory/libs-release/"
        )

        for (url in mavenUrls) {
            maven(url = url)
        }

        mavenCentral()
        gradlePluginPortal()
    }
}
