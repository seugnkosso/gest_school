package com.spring_GestSchool.spring_flutter.mobile.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JustificationRequestDto {
    private Long idAbsence;
    private String motif;
}
