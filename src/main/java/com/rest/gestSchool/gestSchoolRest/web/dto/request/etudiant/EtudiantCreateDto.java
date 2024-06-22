package com.rest.gestSchool.gestSchoolRest.web.dto.request.etudiant;

import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtudiantCreateDto {
    private String telephone;
    private String matricule;
    private String nomComplet;

    public Etudiant createEtudiant(EtudiantCreateDto etudiantCreateDto) {
        Etudiant etudiant = new Etudiant();
        etudiant.setTelephone(etudiantCreateDto.getTelephone());
        etudiant.setMatricule(etudiantCreateDto.getMatricule());
        etudiant.setNomComplet(etudiantCreateDto.getNomComplet());
        etudiant.setEmail(getEmail(etudiantCreateDto)+"@ism.edu.sn");
        etudiant.setUsername(etudiantCreateDto.getTelephone());
        return etudiant;
    }

    private String getEmail(EtudiantCreateDto etudiantCreateDto){
        String name = "";
        List<String> noms = List.of(etudiantCreateDto.getNomComplet().split(" "));
        for (int i = 0; i < noms.size(); i++) {
            if(i == noms.size()-1){
                name += noms.get(i);
            }else{
                name += noms.get(i)+".";
            }
        }
        return name;
    }
}
