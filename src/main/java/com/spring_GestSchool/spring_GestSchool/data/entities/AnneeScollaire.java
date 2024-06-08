package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "anneeScolaires")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnneeScollaire extends AbstractEntity {
    private String libelle;

    @OneToMany(mappedBy = "anneeScolaire")
    private List<Inscription> listeInscriptions;

    @OneToMany(mappedBy = "anneeScolaire")
    private List<Classe> listeclasse;

    @OneToMany(mappedBy = "anneeScolaire")
    private List<Cour> listeCour;

}
