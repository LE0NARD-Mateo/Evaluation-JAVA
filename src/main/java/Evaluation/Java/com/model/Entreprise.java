package Evaluation.Java.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true, nullable = false)
    String nom;

    @OneToMany(mappedBy = "utilisateurDansEntreprise")
    List<Utilisateur> utilisateurs;

    @OneToMany(mappedBy = "conventionParEntreprise")
    List<Convention> conventions;
}
