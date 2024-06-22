package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.CourService;
import com.spring_GestSchool.spring_GestSchool.data.repositories.CourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourServiceImpl implements CourService {
    private final CourRepository courRepository;
}
