package com.springWeb.SpringWeb.web.controllers.impl;

import com.springWeb.SpringWeb.services.EtudiantService;
import com.springWeb.SpringWeb.services.SessionCourService;
import com.springWeb.SpringWeb.web.controllers.EtudiantController;
import com.springWeb.SpringWeb.web.dto.request.absence.AbsenceCreateDto;
import com.springWeb.SpringWeb.web.dto.response.etudiant.EtudiantListDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EtudiantControllerImpl implements EtudiantController {
    private final EtudiantService etudiantService;
    private final SessionCourService sessionCourService;

    @Override
    public String listeretudiants(Model model, @PathVariable Long idSessionCour) {
        List<Etudiant> allBySessionCourId = etudiantService.getAllBySessionCourId(idSessionCour);
        List<EtudiantListDto> etudiantListDtos = allBySessionCourId.stream().map(et -> EtudiantListDto.toDto(et,sessionCourService.getByid(idSessionCour))).toList();
        model.addAttribute("datas",etudiantListDtos);
        model.addAttribute("absentsForm",new AbsenceCreateDto(new ArrayList<>(),idSessionCour));
        model.addAttribute("idSessionCour", idSessionCour);
        return "etudiant/liste";
    }
}
