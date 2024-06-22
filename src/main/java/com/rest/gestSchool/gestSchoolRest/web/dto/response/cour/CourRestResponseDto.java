package com.rest.gestSchool.gestSchoolRest.web.dto.response.cour;

import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourRestResponseDto {
    private Long id;
    private Long nbrHeure;
    private String EtatCour;
    private Boolean isValider;
    private String professeur;
    private String semestre;
    private String module;
    private String listeClasse;

    public static CourRestResponseDto toDto(Cour cour) {
        return CourRestResponseDto.builder()
                .id(cour.getId())
                .nbrHeure(cour.getNbrHeure())
                .EtatCour(cour.getEtatCour())
                .isValider(cour.getIsValider())
                .professeur(cour.getProfesseur().getNomComplet()+" | "+cour.getProfesseur().getTelephone())
                .semestre(cour.getSemestre().getLibelle())
                .module(cour.getModule().getLibelle())
                .listeClasse(getClase(cour.getListeClasse()))
                .build();
    }
    private static String getClase(List<Classe> classes){
        String cl = "";
        for (int i = 0; i < classes.size(); i++) {
            cl += classes.get(i).getLibelle() + " | ";
        }
        return cl;
    }
}
