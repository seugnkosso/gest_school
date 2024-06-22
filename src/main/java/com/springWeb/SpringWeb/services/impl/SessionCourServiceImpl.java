package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.SessionCourService;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SessionCourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionCourServiceImpl implements SessionCourService {
    private final SessionCourRepository sessionCourRepository;

    @Override
    public Page<SessionCour> getAllSessionByProfId(Long idProf, Pageable pageable) {
        return sessionCourRepository.findSessionByProfId(idProf,pageable);
    }

    @Override
    public SessionCour getByid(Long id) {
        return sessionCourRepository.findById(id).get();
    }

    @Override
    public void ValiderSession(Long idSession) {
        SessionCour sessionCour = sessionCourRepository.findById(idSession).get();
        sessionCour.setIsValider(true);
        sessionCourRepository.save(sessionCour);
    }
}
