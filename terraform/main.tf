provider "kubernetes" {
  config_path = "~/.kube/config"
}

resource "kubernetes_namespace" "hostel" {
  metadata {
    name = "hostel-namespace"
  }
}