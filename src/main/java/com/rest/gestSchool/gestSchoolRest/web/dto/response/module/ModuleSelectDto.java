package com.rest.gestSchool.gestSchoolRest.web.dto.response.module;

import com.spring_GestSchool.spring_GestSchool.data.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuleSelectDto {
    private Long id;
    private String libelle;

    public static ModuleSelectDto toDto(Module module) {
        return ModuleSelectDto.builder()
                .id(module.getId())
                .libelle(module.getLibelle())
                .build();
    }
}
