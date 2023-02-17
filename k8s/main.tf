resource "null_resource" "k8s" {
  provisioner "local-exec" {
    command = "microk8s start"
  }
  provisioner "local-exec" {
    command = "microk8s status --wait-ready"
  }
}