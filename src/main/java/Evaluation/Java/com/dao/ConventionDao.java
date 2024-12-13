package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Convention;
import Evaluation.Java.com.model.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConventionDao extends JpaRepository<Convention, Integer> {

    @Query("SELECT s FROM Salarie s WHERE s.salarieParConvention.id = :conventionId")
    List<Salarie> findSalariesByConventionId(@Param("conventionId") Integer conventionId);

}
