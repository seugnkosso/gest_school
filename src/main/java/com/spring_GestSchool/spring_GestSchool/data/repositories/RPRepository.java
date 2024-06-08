package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.RP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RPRepository extends JpaRepository<RP,Long> {

}
