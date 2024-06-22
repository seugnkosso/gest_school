package com.springWeb.SpringWeb.web.controllers.impl;

import com.springWeb.SpringWeb.web.controllers.ProfesseurController;
import com.springWeb.SpringWeb.web.dto.request.absence.AbsenceCreateDto;
import com.springWeb.SpringWeb.web.dto.request.professeur.searchprof;
import com.springWeb.SpringWeb.web.dto.response.professeur.ProfesseurListeDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class ProfesseurControllerImpl implements ProfesseurController {
    private final ProfesseurRepository professeurRepository;
    @Override
    public String listerProfesseur( Model model, int page, int size, String tel) {
        Page<Professeur> allByTelephone = professeurRepository.findAllByTelephone(tel, PageRequest.of(page, size));
        Page<ProfesseurListeDto> professeurListeDtos = allByTelephone.map(ProfesseurListeDto::toDto);
        model.addAttribute("professeurs", professeurListeDtos.getContent());
        model.addAttribute("clientsTotal", professeurListeDtos.getTotalElements());
        model.addAttribute("size", (long) professeurListeDtos.getContent().size());
        model.addAttribute("pages", new int[professeurListeDtos.getTotalPages()]);
        model.addAttribute("nbrPage", professeurListeDtos.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", tel);
        return "professeur/liste";
    }
}
