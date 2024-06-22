package com.springWeb.SpringWeb.web.dto.response.justification;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JustificationListeDto {
    private Long idAbsence;
    private String date;
    private String motif;
    private String etudiant;
    private Boolean isvalider ;

    public static JustificationListeDto toDto(Absence absence) {
        return JustificationListeDto.builder()
                .idAbsence(absence.getId())
                .date(absence.getJustication().getDate().toString())
                .motif(absence.getJustication().getMotif())
                .etudiant(absence.getEtudiant().getNomComplet() +" "+absence.getEtudiant().getTelephone())
                .isvalider(absence.getJustication().getIsvalider())
                .build();
    }

}
