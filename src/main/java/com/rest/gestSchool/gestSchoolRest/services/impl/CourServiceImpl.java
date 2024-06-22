package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.CourService;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.cour.CourCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourServiceImpl implements CourService {
    private final CourRepository courRepository;
    private final ProfesseurRepository professeurRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final SemestreRepository semestreRepository;
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;

    @Override
    public Page<Cour> getAllCourprofesseurId(Long idProfesseur,String telephone, Pageable pageable) {
        Page<Cour> cours = courRepository.findByprofesseurIdInCour(idProfesseur,telephone, pageable);
        return cours;
    }

    @Override
    public Page<Cour> getAllCour(String tel,Pageable pageable) {
        Page<Cour> cours = courRepository.findAllByProfTel(tel,pageable);
        return cours;
    }

    @Override
    public CourCreateRequestDto save(CourCreateRequestDto dto) {
        Cour cour = new Cour();
        cour.setNbrHeure(dto.getNbrHeure());
        cour.setProfesseur(professeurRepository.findById(dto.getProfesseur()).get());
        cour.setAnneeScolaire(anneeScolaireRepository.findByActiveTrue());
        cour.setSemestre(semestreRepository.findById(dto.getSemestre()).get());
        cour.setModule(moduleRepository.findById(dto.getModule()).get());
        cour.setListeClasse(getClasse(dto.getClasses()));
        cour.setIsValider(false);
        courRepository.save(cour);
        getClasse(dto.getClasses()).forEach(classe -> {
            classe.getListeCour().add(cour);
        });
        classeRepository.flush();
        return null;
    }

    private List<Classe> getClasse(List<Long> idClasses){
        List<Classe> classes = new ArrayList<>();
        idClasses.forEach(aLong -> {
            classes.add(classeRepository.findById(aLong).get());
        });
        return classes;
    }
}
