package com.springWeb.SpringWeb.web.controllers.impl;

import com.springWeb.SpringWeb.services.AbsenceService;
import com.springWeb.SpringWeb.web.controllers.AbsentController;
import com.springWeb.SpringWeb.web.dto.request.absence.AbsenceCreateDto;
import com.springWeb.SpringWeb.web.dto.response.justification.JustificationListeDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AbsentControllerImpl implements AbsentController {
    private final AbsenceService absenceService;
    @Override
    public String saveAbsent(@ModelAttribute AbsenceCreateDto absenceCreateDto) {
        absenceService.saveAbsence(absenceCreateDto);
        return "redirect:/etudiants/sessionCour/"+absenceCreateDto.getIdSession();
    }

    @Override
    public String AbsensNonJustifier(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Absence> allByjusticationFalse = absenceService.getAllByjusticationFalse(PageRequest.of(page,size));
        Page<JustificationListeDto> justificationListeDtos = allByjusticationFalse.map(JustificationListeDto::toDto);
        model.addAttribute("datas", justificationListeDtos.getContent());
        model.addAttribute("dataTotal", justificationListeDtos.getTotalElements());
        model.addAttribute("size", (long) justificationListeDtos.getContent().size());
        model.addAttribute("pages", new int[justificationListeDtos.getTotalPages()]);
        model.addAttribute("nbrPage", justificationListeDtos.getTotalPages());
        model.addAttribute("currentPage", page);
        return "justification/liste";
    }

    @Override
    public String validerJustification(Long idAbsence) {
        absenceService.validerJustification(idAbsence);
        return "redirect:/absence/nonJustifier";
    }
}
