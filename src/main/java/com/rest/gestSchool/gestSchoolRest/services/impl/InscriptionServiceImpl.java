package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.InscriptionService;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.inscription.InscriptionCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import com.spring_GestSchool.spring_GestSchool.data.entities.Inscription;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AnneeScolaireRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ClasseRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.EtudiantRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Page<Inscription> getAllInscrits(String matricule,Pageable pageable) {
        return inscriptionRepository.findAllByMatriculeEtudiant(matricule,pageable);
    }

    @Override
    public Inscription create(InscriptionCreateDto inscriptionCreateDto) {
        Etudiant etudiant = etudiantRepository.getEtudiantsByUsername(inscriptionCreateDto.getEtudiant().getTelephone());
        if(etudiant == null){
            etudiant = inscriptionCreateDto.getEtudiant().createEtudiant(inscriptionCreateDto.getEtudiant());
            etudiant.setClasse(classeRepository.findById(inscriptionCreateDto.getClasse()).get());
            etudiant.setPassword(passwordEncoder.encode("passer"));
            etudiantRepository.save(etudiant);
        }
        Inscription inscription = new Inscription();
        inscription.setAnneeScolaire(anneeScolaireRepository.findById(inscriptionCreateDto.getAnneeScolaire()).get());
        inscription.setEtudiant(etudiant);
        inscriptionRepository.save(inscription);
        return null;
    }


}
