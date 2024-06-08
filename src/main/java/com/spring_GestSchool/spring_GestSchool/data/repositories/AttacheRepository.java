package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Attacher;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttacheRepository extends JpaRepository<Attacher,Long> {
    @Query("select a from Attacher a where a.nomComplet like %:nomComplet% or a.telephone like %:telephone% ")
    List<Attacher> findAllAttacherByNomCompletOrTelephone(@Param("nomComplet") String nomComplet, @Param("telephone") String telephone);
}
