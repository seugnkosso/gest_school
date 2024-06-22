package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.module.ModuleSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ModuleService {
    List<Module> getModuleBykeySearch(String keySearch);

    Page<Module> getAllByPaginate(Pageable pageable);

    Module createModule(ModuleSelectDto moduleSelectDto);
}
