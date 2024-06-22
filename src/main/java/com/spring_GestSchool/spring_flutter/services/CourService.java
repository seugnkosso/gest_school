package com.spring_GestSchool.spring_flutter.services;

import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourService {

    List<Cour> getAllCour(Long idEtudiant);

}
