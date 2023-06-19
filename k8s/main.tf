resource "null_resource" "k8s" {
  provisioner "local-exec" {
    command = "sudo -A microk8s start"
    environment = {
      SUDO_ASKPASS = "/usr/bin/ssh-askpass"
    }
  }

  provisioner "local-exec" {
    when    = destroy
    command = "sudo -A microk8s stop"
    environment = {
      SUDO_ASKPASS = "/usr/bin/ssh-askpass"
    }
  }
}