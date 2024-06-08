package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Salle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {
    Page<Salle> findAllByActiveTrue(Pageable pageable);

    List<Salle> findAllByLibelleContains(String libelle);
}
