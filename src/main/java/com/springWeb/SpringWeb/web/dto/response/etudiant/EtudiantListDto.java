package com.springWeb.SpringWeb.web.dto.response.etudiant;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtudiantListDto {
    private Long id;
    private Boolean absenceNote;
    private String telephone;
    private String matricule;
    private String nomComplet;

    public static EtudiantListDto toDto(Etudiant etudiant, SessionCour sessionCour) {
        return EtudiantListDto.builder()
                .id(etudiant.getId())
                .absenceNote(AbsenceNote(etudiant.getListeAbsence(),sessionCour.getListeAbsence()))
                .telephone(etudiant.getTelephone())
                .matricule(etudiant.getMatricule())
                .nomComplet(etudiant.getNomComplet())
                .build();
    }

    private static Boolean AbsenceNote(List<Absence> etudiantAbsence, List<Absence> SessionAbsence) {
        for (Absence etAbs : etudiantAbsence) {
            for (Absence SessAbs : SessionAbsence) {
                if (Objects.equals(etAbs.getId(), SessAbs.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
