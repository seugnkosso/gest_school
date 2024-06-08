package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    @Query("SELECT e FROM Etudiant e JOIN e.classe c WHERE c.attacher.id = :idAttacher")
    Page<Etudiant> findByAttacherIdInClasse (@Param("idAttacher") Long idAttacher, Pageable pageable);

    @Query("SELECT e FROM Etudiant e JOIN e.classe c join c.listeCour co join co.listeSessionCour s WHERE s.id = :idSessionCour")
    List<Etudiant> findAllBySessionId (@Param("idSessionCour") Long idSessionCour);

    Etudiant getEtudiantsByUsername(String username);
}
