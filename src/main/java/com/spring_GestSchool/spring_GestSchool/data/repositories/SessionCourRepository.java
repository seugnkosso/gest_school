package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface SessionCourRepository extends JpaRepository<SessionCour,Long> {
    @Query("SELECT s FROM SessionCour s JOIN s.cour c WHERE c.id = :idCour and (s.date between :dateDebut and :dateFin)")
    Page<SessionCour> findByCourIdInSessionCour(@Param("idCour") Long idCour,@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin, Pageable pageable);
    @Query("SELECT s FROM SessionCour s JOIN s.cour c join c.professeur p WHERE c.id = :idCour and p.id = :idProf and (s.date between :dateDebut and :dateFin)")
    Page<SessionCour> findByCourIdInSessionCourAndProf(@Param("idCour") Long idCour,@Param("idProf") Long idProf,@Param("dateDebut") Date dateDebut,@Param("dateFin") Date dateFin, Pageable pageable);

    @Query("SELECT s FROM SessionCour s JOIN s.cour c join c.professeur p WHERE p.id = :idProf")
    Page<SessionCour> findSessionByProfId(@Param("idProf") Long idProf,Pageable pageable);

    List<SessionCour> findAllByCourId(Long idCour);

}
