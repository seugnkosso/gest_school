package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.AnneeScollaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneeScollaire,Long> {
    Page<AnneeScollaire> findAllByActiveTrue(Pageable pageable);
    List<AnneeScollaire> findAllByLibelleContains(String libelle);

    AnneeScollaire findByActiveTrue();

}
