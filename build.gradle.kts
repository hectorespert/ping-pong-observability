plugins {
    id("org.jetbrains.gradle.terraform") version "1.5.2"
}

terraform {
    sourceSets {
        all {
            executeApplyOnlyIf { true }
            executeDestroyOnlyIf { true }
        }
        main {
            srcDirs = mutableSetOf(project.file("k8s"))
            lockFile = project.file("k8s/terraform.tfstate")
            stateFile = project.file("k8s/.terraform.lock.hcl")
        }
    }
}