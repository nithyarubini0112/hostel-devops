provider "kubernetes" {
  config_path = "~/.kube/config"
}

# -----------------------------
# Deployment
# -----------------------------
resource "kubernetes_deployment" "hostel_app" {
  metadata {
    name = "hostel-app"
    labels = {
      app = "hostel"
    }
  }

  spec {
    replicas = 2

    selector {
      match_labels = {
        app = "hostel"
      }
    }

    template {
      metadata {
        labels = {
          app = "hostel"
        }
      }

      spec {
        container {
          name  = "hostel-container"
          image = "hostel-app"

          # IMPORTANT for Minikube local image
          image_pull_policy = "Never"

          port {
            container_port = 8080
          }
        }
      }
    }
  }
}

# -----------------------------
# Service (to expose app)
# -----------------------------
resource "kubernetes_service" "hostel_service" {
  metadata {
    name = "hostel-service"
  }

  spec {
    selector = {
      app = "hostel"
    }

    port {
      port        = 80
      target_port = 8080
      node_port   = 30007
    }

    type = "NodePort"
  }
}

# -----------------------------
# Output
# -----------------------------
output "app_info" {
  value = "Hostel app deployed using Terraform (IaC) 🚀"
}