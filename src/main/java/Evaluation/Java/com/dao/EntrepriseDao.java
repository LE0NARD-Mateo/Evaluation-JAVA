package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Convention;
import Evaluation.Java.com.model.Entreprise;
import Evaluation.Java.com.model.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, Integer> {

    @Query("SELECT c FROM Convention c WHERE c.conventionParEntreprise.id = :entrepriseId")
    List<Convention> findAllConventionsByEntrepriseId(@Param("entrepriseId") Integer entrepriseId);

    @Query("SELECT s FROM Salarie s WHERE s.salarieParConvention.conventionParEntreprise.id = :entrepriseId")
    List<Salarie> findAllSalariesByEntrepriseId(@Param("entrepriseId") Integer entrepriseId);
}