package Evaluation.Java.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;

        @Column(unique = true, nullable = false)
        String email;

        @Column(nullable = false)
        String password;

        @ManyToOne
        @JoinColumn(name = "entreprise_id")
        Entreprise utilisateurDansEntreprise;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Entreprise getUtilisateurDansEntreprise() {
                return utilisateurDansEntreprise;
        }

        public void setUtilisateurDansEntreprise(Entreprise utilisateurDansEntreprise) {
                this.utilisateurDansEntreprise = utilisateurDansEntreprise;
        }
}
