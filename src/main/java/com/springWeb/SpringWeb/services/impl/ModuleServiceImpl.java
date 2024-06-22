package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.ModuleService;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;

}
