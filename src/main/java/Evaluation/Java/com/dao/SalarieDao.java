package Evaluation.Java.com.dao;

import Evaluation.Java.com.model.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalarieDao extends JpaRepository<Salarie, Integer> {

    @Query("SELECT s FROM Salarie s WHERE s.salarieParConvention.id = :conventionId")
    List<Salarie> findAllByConventionId(@Param("conventionId") Integer conventionId);
}