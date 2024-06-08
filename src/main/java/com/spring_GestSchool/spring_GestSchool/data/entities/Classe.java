package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Classe extends AbstractEntity {
    private String libelle;
    @ManyToOne
    private Attacher attacher;
    @OneToMany(mappedBy = "classe")
    private List<Etudiant> listeEtudiant;
    @ManyToOne
    private Filliere filiere;
    @ManyToOne
    private Niveau niveau;
    @ManyToOne
    private AnneeScollaire anneeScolaire;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "classe_cour",
            joinColumns = { @JoinColumn(name = "classe_id") },
            inverseJoinColumns = { @JoinColumn(name = "cour_id") }
    )
    private List<Cour> listeCour;
}
