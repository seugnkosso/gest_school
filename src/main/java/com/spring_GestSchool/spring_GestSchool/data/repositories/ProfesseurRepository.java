package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Page<Professeur> findAll(Pageable pageable);

    @Query("SELECT p FROM Professeur p WHERE  p.telephone like %:telephone% or p.nomComplet like %:nomComplet% ")
    List<Professeur> findByTelAndNomComplet(@Param("telephone") String telephone, @Param("nomComplet") String nomComplet);
    @Query("SELECT p FROM Professeur p WHERE  p.telephone like %:telephone% ")
    Page<Professeur> findAllByTelephone(@Param("telephone") String telephone,Pageable pageable);


}
