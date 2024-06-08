package com.spring_GestSchool.spring_GestSchool.data.entities;

import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "etudiants")
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("Etudiant")
public class Etudiant extends AppUser {
    private String matricule;
    @OneToMany(mappedBy = "etudiant")
    private List<Absence> listeAbsence;
    @OneToMany(mappedBy = "etudiant")
    private List<Inscription> listeInscription;
    @ManyToOne
    private Classe classe;
}
