package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SemestreRepository extends JpaRepository<Semestre,Long> {
    List<Semestre> findAllByLibelleContainsAndActiveTrue(String keySearch);

    Page<Semestre> findAllByActiveTrue(Pageable pageable);
}
