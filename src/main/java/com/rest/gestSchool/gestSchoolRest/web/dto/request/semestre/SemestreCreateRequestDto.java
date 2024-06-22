package com.rest.gestSchool.gestSchoolRest.web.dto.request.semestre;


import com.rest.gestSchool.gestSchoolRest.web.dto.response.classe.ClasseSelectDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.module.ModuleSelectDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurSelectDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.semestre.SemestreSelectDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SemestreCreateRequestDto {
    private String libelle;
}
