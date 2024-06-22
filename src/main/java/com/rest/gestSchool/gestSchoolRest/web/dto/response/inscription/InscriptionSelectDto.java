package com.rest.gestSchool.gestSchoolRest.web.dto.response.inscription;

import com.spring_GestSchool.spring_GestSchool.data.entities.Inscription;
import com.spring_GestSchool.spring_GestSchool.data.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InscriptionSelectDto {
    private Long id;
    private String date;
    private String etudiant;
    private Long idEtudiant;
    private String anneeScolaire;

    public static InscriptionSelectDto toDto(Inscription inscription) {
        return InscriptionSelectDto.builder()
                .id(inscription.getId())
                .date(inscription.getDate().toString())
                .etudiant(inscription.getEtudiant().getMatricule()+" | "+inscription.getEtudiant().getNomComplet()+" | "+inscription.getEtudiant().getTelephone()+" | "+inscription.getEtudiant().getEmail())
                .idEtudiant(inscription.getEtudiant().getId())
                .anneeScolaire(inscription.getAnneeScolaire().getLibelle())
                .build();
    }
}
