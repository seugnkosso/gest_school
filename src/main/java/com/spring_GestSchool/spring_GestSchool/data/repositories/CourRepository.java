package com.spring_GestSchool.spring_GestSchool.data.repositories;

import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourRepository extends JpaRepository<Cour, Long> {
    @Query("SELECT c FROM Cour c JOIN c.listeClasse cl join cl.listeEtudiant e WHERE e.id = :idEtudiant")
    Page<Cour> findByEtudinatIdIdInCour(@Param("idEtudiant") Long idEtudiant, Pageable pageable);

    @Query("SELECT c FROM Cour c JOIN c.listeClasse cl WHERE cl.id = :idClasse")
    Page<Cour> findByClassedIdInCour(@Param("idClasse") Long idClasse, Pageable pageable);
    @Query("SELECT c FROM Cour c JOIN c.professeur p join c.listeClasse cl  WHERE p.id = :idProfesseur and (p.telephone like %:telephone% or cl.libelle like %:telephone%) ")
    Page<Cour> findByprofesseurIdInCour(@Param("idProfesseur") Long idProfesseur,@Param("telephone") String telephone, Pageable pageable);

    @Query("SELECT c FROM Cour c JOIN c.professeur p join c.listeClasse cl  WHERE (p.telephone like %:telephone% or cl.libelle like %:telephone%) ")
    Page<Cour> findAllByProfTel(@Param("telephone") String tel, Pageable pageable);

    @Query("select c from Cour c join c.listeClasse cl join cl.listeEtudiant e where e.id = :idEtudiant")
    List<Cour> findAllByEtudiant(@Param("idEtudiant") Long idEtudiant);

}
