package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.ProfesseurService;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {
    private final ProfesseurRepository professeurRepository;

}
