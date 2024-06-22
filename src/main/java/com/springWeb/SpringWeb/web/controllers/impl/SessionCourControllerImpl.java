package com.springWeb.SpringWeb.web.controllers.impl;

import com.springWeb.SpringWeb.services.SessionCourService;
import com.springWeb.SpringWeb.web.controllers.SessionCourController;
import com.springWeb.SpringWeb.web.dto.response.sessionCour.SessionCourRestResponseDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class SessionCourControllerImpl implements SessionCourController {
    private final SessionCourService sessionCourService;
    @Override
    public String listerProfesseur(Model model, int page, int size, Long idProf) {
        Page<SessionCour> allSessionByProfId = sessionCourService.getAllSessionByProfId(idProf, PageRequest.of(page, size));
        Page<SessionCourRestResponseDto> sessionCourRestResponseDtos = allSessionByProfId.map(SessionCourRestResponseDto::toDto);
        model.addAttribute("datas", sessionCourRestResponseDtos.getContent());
        model.addAttribute("clientsTotal", sessionCourRestResponseDtos.getTotalElements());
        model.addAttribute("size", (long) sessionCourRestResponseDtos.getContent().size());
        model.addAttribute("pages", new int[sessionCourRestResponseDtos.getTotalPages()]);
        model.addAttribute("nbrPage", sessionCourRestResponseDtos.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("idProf", idProf);
        return "sessionCour/liste";
    }

    @Override
    public String validerSession(
            @PathVariable Long idSession,
            @PathVariable Long idP
    ) {
         sessionCourService.ValiderSession(idSession);
        return "redirect:/sessionCours/professeur/" + idP;
    }
}
