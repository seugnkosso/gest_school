package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    @Query("SELECT a FROM Absence a JOIN a.etudiant e WHERE e.id = :idEtudiant")
    Page<Absence> findByEtudiantIdInAbsence(@Param("idEtudiant") Long idEtudiant, Pageable pageable);

    List<Absence> findAllByEtudiantId(Long idEtudiant);

    @Query("SELECT a FROM Absence a JOIN a.justication j WHERE j.isvalider = false and j.motif != '' ")
    Page<Absence> findByJustificationFalse(Pageable pageable);
}
