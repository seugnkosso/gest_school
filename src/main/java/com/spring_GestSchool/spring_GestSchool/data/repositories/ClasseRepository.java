package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    Page<Classe> findAllByLibelleContainsAndAttacherIdAndActiveTrue(String search, Long idAttacher, Pageable pageable);

    List<Classe> findAllByLibelleContainsAndActiveTrue(String keySearch);

    Classe findByLibelleContains(String libelle);

    Page<Classe> findAllByActiveTrue(Pageable pageable);
}
