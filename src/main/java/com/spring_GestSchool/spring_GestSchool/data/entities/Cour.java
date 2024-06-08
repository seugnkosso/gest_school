package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cours")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cour extends AbstractEntity {
    private Long nbrHeure;
    private String EtatCour;
    private Boolean isValider = false;
    @ManyToOne
    private Professeur professeur;
    @ManyToOne
    private AnneeScollaire anneeScolaire;
    @ManyToOne
    private Semestre semestre;
    @ManyToOne
    private Module module;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listeCour")
    private List<Classe> listeClasse;
    @OneToMany(mappedBy = "cour")
    private List<SessionCour> listeSessionCour;
}
