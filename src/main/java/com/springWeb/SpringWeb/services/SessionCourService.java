package com.springWeb.SpringWeb.services;


import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SessionCourService {
    Page<SessionCour> getAllSessionByProfId(Long idProf, Pageable pageable);
    SessionCour getByid(Long id);

    void ValiderSession(Long idSession);

}
