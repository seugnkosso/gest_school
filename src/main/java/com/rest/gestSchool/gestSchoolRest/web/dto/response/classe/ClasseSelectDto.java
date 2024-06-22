package com.rest.gestSchool.gestSchoolRest.web.dto.response.classe;

import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClasseSelectDto {
    private Long id;
    private String libelle;

    public static ClasseSelectDto toDto(Classe classe) {
        return ClasseSelectDto.builder()
                .id(classe.getId())
                .libelle(classe.getLibelle())
                .build();
    }
}
