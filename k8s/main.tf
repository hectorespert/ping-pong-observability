terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
    }
  }
  required_version = ">= 0.13"
}

provider "scaleway" {

}

resource "null_resource" "k8s" {
  provisioner "local-exec" {
    command = "ls"
  }
}