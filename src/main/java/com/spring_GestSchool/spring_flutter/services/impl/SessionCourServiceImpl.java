package com.spring_GestSchool.spring_flutter.services.impl;

import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.CourRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SalleRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SessionCourRepository;
import com.spring_GestSchool.spring_flutter.services.SessionCourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionCourServiceImpl implements SessionCourService {
    private final SessionCourRepository sessionCourRepository;
    private final CourRepository courRepository;
    private final SalleRepository salleRepository;

    @Override
    public List<SessionCour> getAllByCour(Long idCour) {
        return sessionCourRepository.findAllByCourId(idCour);
    }

}
