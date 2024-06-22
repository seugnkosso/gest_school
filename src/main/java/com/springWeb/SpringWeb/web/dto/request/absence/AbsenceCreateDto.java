package com.springWeb.SpringWeb.web.dto.request.absence;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbsenceCreateDto {
    private List<Long> idEtudiant = new ArrayList<>();
    private  Long idSession;
}
