package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;


import com.rest.gestSchool.gestSchoolRest.services.ModuleService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.ModuleRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.module.ModuleSelectDto;

import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Module;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class ModuleRestControllerImpl implements ModuleRestController {
    private final ModuleService moduleService;
    @Override
    public ResponseEntity<?> searchModule(String keySearch) {
        List<Module> moduleBykeySearch = moduleService.getModuleBykeySearch(keySearch);
        List<ModuleSelectDto> moduleSelectDtos = moduleBykeySearch.stream().map(ModuleSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(moduleSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> modules(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Module> allByPaginate = moduleService.getAllByPaginate(PageRequest.of(page, size));
        Page<ModuleSelectDto> moduleSelectDtos = allByPaginate.map(ModuleSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                moduleSelectDtos.getContent(),
                moduleSelectDtos.getTotalElements(),
                moduleSelectDtos.getTotalPages(),
                (long) moduleSelectDtos.getContent().size(),
                new int[moduleSelectDtos.getTotalPages()],
                moduleSelectDtos.getTotalPages(),
                moduleSelectDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crateModules(ModuleSelectDto moduleSelectDto) {
        Module module = moduleService.createModule(moduleSelectDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
