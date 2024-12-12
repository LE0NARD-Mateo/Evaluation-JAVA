package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConventionDao extends JpaRepository<Convention, Integer> {

}
