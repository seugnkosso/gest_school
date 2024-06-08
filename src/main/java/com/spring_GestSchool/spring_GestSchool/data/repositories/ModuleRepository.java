package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {
    List<Module> findAllByLibelleContainsAndActiveTrue(String keySearch);
    Page<Module> findAll(Pageable pageable);
}
