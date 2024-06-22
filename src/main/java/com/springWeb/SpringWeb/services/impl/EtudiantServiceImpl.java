package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.EtudiantService;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import com.spring_GestSchool.spring_GestSchool.data.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;


    @Override
    public List<Etudiant> getAllBySessionCourId(Long idSessionCour) {
        return etudiantRepository.findAllBySessionId(idSessionCour);
    }
}
