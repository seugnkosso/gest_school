package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import com.spring_GestSchool.spring_GestSchool.data.entities.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NiveauRepository extends JpaRepository<Niveau,Long> {
    List<Niveau> findAllByLibelleContains(String libelle);

    Page<Niveau> findAll(Pageable pageable);

}
