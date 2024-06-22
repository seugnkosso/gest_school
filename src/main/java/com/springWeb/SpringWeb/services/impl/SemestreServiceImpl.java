package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.SemestreService;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SemestreServiceImpl implements SemestreService {
    private final SemestreRepository semestreRepository;
}
