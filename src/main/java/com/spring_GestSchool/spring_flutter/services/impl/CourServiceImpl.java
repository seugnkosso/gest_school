package com.spring_GestSchool.spring_flutter.services.impl;

import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.*;
import com.spring_GestSchool.spring_flutter.services.CourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourServiceImpl implements CourService {
    private final CourRepository courRepository;

    @Override
    public List<Cour> getAllCour(Long idEtudiant) {
        List<Cour> cours = courRepository.findAllByEtudiant(idEtudiant);
        return cours;
    }

}
