plugins {
    id("org.jetbrains.gradle.terraform") version "1.5.2"
}

terraform {
    version = "1.3.9"
    sourceSets {
        all {
            executeApplyOnlyIf { true }
            executeDestroyOnlyIf { true }
        }
        main {
            srcDirs = mutableSetOf(project.file("k8s"))
            lockFile = project.file("k8s/.terraform.lock.hcl")
            stateFile = project.file("k8s/terraform.tfstate")
        }
    }
}

tasks.register("start") {
    dependsOn(":terraformApply")
    doLast {
        println("Start project")
    }
}

tasks.register("stop") {
    dependsOn(":terraformDestroy")
    doLast {
        println("Stop project")
    }
}