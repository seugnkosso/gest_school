package com.springWeb.SpringWeb.services;


import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllBySessionCourId(Long idSessionCour);
}
