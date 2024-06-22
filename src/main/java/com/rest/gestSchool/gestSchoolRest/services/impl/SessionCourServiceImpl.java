package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.SessionCourService;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.sessionCour.SessionCourCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.CourRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SalleRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SessionCourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SessionCourServiceImpl implements SessionCourService {
    private final SessionCourRepository sessionCourRepository;
    private final CourRepository courRepository;
    private final SalleRepository salleRepository;

    @Override
    public Page<SessionCour> getAllByCour(Long idCour, String dateDebut, String dateFin, Pageable pageable) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date DateDebut = new Date();
        Date DateFin = new Date();
        try {
            DateDebut = format.parse(dateDebut);
            DateFin = format.parse(dateFin);
        } catch (ParseException e) {
        }
        return sessionCourRepository.findByCourIdInSessionCour(idCour, DateDebut, DateFin, pageable);
    }

    @Override
    public Page<SessionCour> getAllByCourProf(Long idCour, Long idProf, String dateDebut, String dateFin, Pageable pageable) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date DateDebut = new Date();
        Date DateFin = new Date();
        try {
            DateDebut = format.parse(dateDebut);
            DateFin = format.parse(dateFin);
        } catch (ParseException e) {
        }
        return sessionCourRepository.findByCourIdInSessionCourAndProf(idCour, idProf, DateDebut, DateFin, pageable);
    }

    @Override
    public Boolean SessionProfExist(int idCour, String heureDebut, String HeureFin, String date) {
        boolean sessionprofExist = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = new Date();
        try {
            dat = format.parse(date);
        } catch (ParseException e) {
        }
        Cour cour = courRepository.findById((long) idCour).get();
        for (Cour cour1 : cour.getProfesseur().getListeCour()) {
            sessionprofExist = isSessionExist(heureDebut, HeureFin, sessionprofExist, dat, cour1);
        }
        return sessionprofExist;
    }

    @Override
    public Boolean SessionClasseExist(int idCour, String heureDebut, String HeureFin, String date) {
        boolean sessionClasseExist = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = new Date();
        try {
            dat = format.parse(date);
        } catch (ParseException e) {
        }
        Cour cour = courRepository.findById((long) idCour).get();
        for (Classe classe : cour.getListeClasse()) {
            for (Cour cour1 : classe.getListeCour()) {
                sessionClasseExist = isSessionExist(heureDebut, HeureFin, sessionClasseExist, dat, cour1);
            }
        }
        return sessionClasseExist;
    }

    @Override
    public SessionCour Create(SessionCourCreateDto sessionCourCreateDto) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Date heureDebut = new Date();
        Date heureFin = new Date();
        try {
            date = format.parse(sessionCourCreateDto.getDate() + " 00:00:00");
            heureDebut = format.parse("0000-00-00 " + sessionCourCreateDto.getHeureDebut() + ":00");
            heureFin = format.parse("0000-00-00 " + sessionCourCreateDto.getHeureFin() + ":00");
        } catch (ParseException e) {
            System.out.println(date);
        }
        SessionCour sessionCour = new SessionCour();
        sessionCour.setDate(date);
        sessionCour.setHeureDebut(heureDebut);
        sessionCour.setHeureFin(heureFin);
        if (sessionCourCreateDto.getSalle() != 0) {
            sessionCour.setSalle(salleRepository.findById(sessionCourCreateDto.getSalle()).get());
        }
        sessionCour.setCour(courRepository.findById(sessionCourCreateDto.getCour()).get());
        sessionCour.setEtat(sessionCourCreateDto.getEtat());
        sessionCourRepository.save(sessionCour);
        return null;
    }

    private boolean isSessionExist(String heureDebut, String HeureFin, boolean sessionClasseExist, Date dat, Cour cour1) {
        SimpleDateFormat format;
        for (SessionCour sessionCour : cour1.getListeSessionCour()) {
            format = new SimpleDateFormat("HH:mm");
            if (dat.equals(sessionCour.getDate())) {
                Date Heure = new Date();
                Date heureFin = new Date();
                try {
                    Heure = format.parse(heureDebut);
                    heureFin = format.parse(HeureFin);
                    if (Heure.equals(sessionCour.getHeureDebut()) || (Heure.after(sessionCour.getHeureDebut()) && Heure.before(sessionCour.getHeureFin())) || (heureFin.after(sessionCour.getHeureDebut()) && heureFin.before(sessionCour.getHeureFin())) || (sessionCour.getHeureDebut().after(Heure) && sessionCour.getHeureDebut().before(heureFin)) || (sessionCour.getHeureFin().after(Heure) && sessionCour.getHeureFin().before(heureFin))) {
                        sessionClasseExist = true;
                        break;
                    }
                } catch (ParseException e) {
                }
            }
        }
        return sessionClasseExist;
    }
}
