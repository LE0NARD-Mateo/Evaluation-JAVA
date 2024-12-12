package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseDao extends JpaRepository<Utilisateur, Integer> {

}
