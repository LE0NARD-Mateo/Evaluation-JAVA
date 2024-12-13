package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConventionDao extends JpaRepository<Convention, Integer> {

    @Query("SELECT c FROM Convention c WHERE c.conventionParEntreprise.id = :entrepriseId")
    List<Convention> findAllConventionsByEntrepriseId(@Param("entrepriseId") Integer entrepriseId);

}
