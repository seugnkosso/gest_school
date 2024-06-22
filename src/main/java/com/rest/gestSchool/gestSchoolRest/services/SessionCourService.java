package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.sessionCour.SessionCourCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SessionCourService {
    Page<SessionCour> getAllByCour(Long idCour,String dateDebut,String dateFin, Pageable pageable);
    Page<SessionCour> getAllByCourProf(Long idCour,Long idProf,String dateDebut,String dateFin, Pageable pageable);

    Boolean SessionProfExist(int idCour,String heureDebut,String HeureFin,String date);
    Boolean SessionClasseExist(int idCour,String heureDebut,String HeureFin,String date);

    SessionCour Create(SessionCourCreateDto sessionCourCreateDto);
}
