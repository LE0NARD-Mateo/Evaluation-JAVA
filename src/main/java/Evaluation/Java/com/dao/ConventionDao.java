package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConventionDao extends JpaRepository<Utilisateur, Integer> {

}