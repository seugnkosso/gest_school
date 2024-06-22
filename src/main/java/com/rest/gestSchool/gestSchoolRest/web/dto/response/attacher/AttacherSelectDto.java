package com.rest.gestSchool.gestSchoolRest.web.dto.response.attacher;

import com.spring_GestSchool.spring_GestSchool.data.entities.Attacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttacherSelectDto {
    private Long id;
    private String nomComplet;

    public static AttacherSelectDto toDto(Attacher attacher) {
        return AttacherSelectDto.builder()
                .id(attacher.getId())
                .nomComplet(attacher.getNomComplet())
                .build();
    }
}
