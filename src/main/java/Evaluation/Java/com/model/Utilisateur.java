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
}
