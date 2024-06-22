package com.spring_GestSchool.spring_flutter.mobile.dto.response.absence;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.entities.Justification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbsenceRestResponseDto {
    private Long id;
    private String date;
    private String cour;
    private Boolean isValider;
    private String motif;

    public static AbsenceRestResponseDto toDto(Absence absence) {
        return AbsenceRestResponseDto.builder()
                .id(absence.getId())
                .date(absence.getSessionCour().getDate().toString())
                .isValider(getIsValider(absence.getJustication()) )
                .cour(absence.getSessionCour().getCour().getModule().getLibelle()+" "+absence.getSessionCour().getCour().getSemestre().getLibelle())
                .motif(absence.getJustication() != null && absence.getJustication().getMotif() != null ? absence.getJustication().getMotif() : "" )
                .build();
    }
    private static Boolean getIsValider(Justification justification){
        if(justification != null){
            return justification.getIsvalider();
        };
        return false;
    }
}