package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.ModuleService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.module.ModuleSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Module;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    @Override
    public List<Module> getModuleBykeySearch(String keySearch) {
        List<Module> all = moduleRepository.findAllByLibelleContainsAndActiveTrue(keySearch);
        return all;
    }

    @Override
    public Page<Module> getAllByPaginate(Pageable pageable) {
        return moduleRepository.findAll(pageable);
    }

    @Override
    public Module createModule(ModuleSelectDto moduleSelectDto) {
        Module module = new Module();
        module.setLibelle(moduleSelectDto.getLibelle());
        moduleRepository.save(module);
        return null;
    }
}
