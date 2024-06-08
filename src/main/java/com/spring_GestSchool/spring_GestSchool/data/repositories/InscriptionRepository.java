package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Long> {

    @Query("Select i from Inscription i join i.etudiant e  where  e.matricule like  %:matricule%")
    Page<Inscription> findAllByMatriculeEtudiant(@Param("matricule") String matricule, Pageable pageable);
}
