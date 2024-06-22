package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.ClasseService;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;

}
