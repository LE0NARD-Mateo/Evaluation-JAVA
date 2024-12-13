package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    @Query("SELECT u FROM Utilisateur u WHERE u.utilisateurDansEntreprise.id = :entrepriseId")
    List<Utilisateur> findAllByEntrepriseId(@Param("entrepriseId") Integer entrepriseId);


    Optional<Utilisateur> findByEmail(String email);
}
