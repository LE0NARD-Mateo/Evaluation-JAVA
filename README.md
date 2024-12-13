# ExplicationJson

 Evaluation Java Api

si une erreur 500 se produit voilà les json que j'ai utiliser pour chaque page en post et put :

http://localhost:8080/entreprise :

{
    "nom": "Carrefours"
  }

http://localhost:8080/convention:

{
  "nom": "contrat5",
  "subvention": 2000.99,
  "salarie_Maximum": 2,
  "conventionParEntreprise": {
    "id": 2
  }
}

http://localhost:8080/utilisateur:

{
    "email": "tata@gmail.com",
    "password": "$2a$10$wlLBMf0wrA4XqcigEqeIjuZJ5zwCrS7PYgUrrThUAiAfqehK3NIty",
    "utilisateurDansEntreprise": null
  }

http://localhost:8080/salarie:
{
  "matricule": "lamon",
  "codeBarre": "54155",
  "salarieParConvention": {
    "id": 1,
    "salarie_Maximum": 2
  }
}

bearer admin : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0YXRhQGdtYWlsLmNvbSJ9.gjARm3bgLR-JIcplHeIZgbaExyMzprOFuA5W8eQJAMw

bearer entreprise : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b3RvQGdtYWlsLmNvbSJ9.eZ5kVXS2J3bQoEx2eGeKwSlCTZLEMXhH20IwqINqxxI

mot de passe pour chaque utilisateur : azerty

http://localhost:8080/connexion:

{
    "email": "tata@gmail.com",
    "password": "azerty"
  },

pour bearer admin

http://localhost:8080/connexion:

{
    "email": "toto@gmail.com",
    "password": "azerty"
  },

pour bearer entreprise
