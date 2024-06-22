package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.AttacherService;
import com.spring_GestSchool.spring_GestSchool.data.entities.Attacher;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AttacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttacherServiceImpl implements AttacherService {
    private final AttacheRepository attacheRepository;
    @Override
    public List<Attacher> getAllByNomOrTel(String telOrNom) {
        return attacheRepository.findAllAttacherByNomCompletOrTelephone(telOrNom,telOrNom);
    }
}
