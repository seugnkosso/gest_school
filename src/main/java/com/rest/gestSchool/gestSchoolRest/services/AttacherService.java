package com.rest.gestSchool.gestSchoolRest.services;

import com.spring_GestSchool.spring_GestSchool.data.entities.Attacher;

import java.util.List;

public interface AttacherService {
    List<Attacher> getAllByNomOrTel(String telOrNom);
}
