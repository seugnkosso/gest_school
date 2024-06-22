package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.SalleService;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.salle.SalleCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Salle;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalleServiceImpl implements SalleService {
    private final SalleRepository salleRepository;

    @Override
    public Page<Salle> getAllSallePage(Pageable pageable) {
        return salleRepository.findAllByActiveTrue(pageable);
    }

    @Override
    public Salle CreateSalle(SalleCreateDto salleCreateDto) {
        Salle salle = new Salle();
        salle.setLibelle(salleCreateDto.getLibelle());
        salle.setNumero(salleCreateDto.getNumero());
        salle.setNbrPlace(salleCreateDto.getNbrPlace());
        salleRepository.save(salle);
        return null;
    }

    @Override
    public List<Salle> getAllSalleByLibelleAndNoSessionCour(String libelle, String date, String HeureDebut, String HeureFin) {
        List<Salle> allByLibelleContains = salleRepository.findAllByLibelleContains(libelle);
        List<Salle> salleNoOccuper = new ArrayList<>();
        salleNoOccuper.addAll(allByLibelleContains);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = new Date();
        try {
            dat = format.parse(date);
        } catch (ParseException e) {
        }
        for (Salle salle : allByLibelleContains){
            for (SessionCour sessionCour : salle.getListeSessionCour()){
                format = new SimpleDateFormat("HH:mm");
                if (dat.equals(sessionCour.getDate())) {
                    Date heureDebut = new Date();
                    Date heureFin = new Date();
                    try {
                        heureDebut = format.parse(HeureDebut);
                        heureFin = format.parse(HeureFin);
                        if (heureDebut.equals(sessionCour.getHeureDebut()) || (heureDebut.after(sessionCour.getHeureDebut()) && heureDebut.before(sessionCour.getHeureFin())) || (heureFin.after(sessionCour.getHeureDebut()) && heureFin.before(sessionCour.getHeureFin())) || (sessionCour.getHeureDebut().after(heureDebut) && sessionCour.getHeureDebut().before(heureFin))  || (sessionCour.getHeureFin().after(heureDebut) && sessionCour.getHeureFin().before(heureFin))) {
                        }else{
                            salleNoOccuper.remove(salle);
                        }
                    } catch (ParseException e) {
                    }
                }
            }
        }
        return salleNoOccuper;
    }
}
