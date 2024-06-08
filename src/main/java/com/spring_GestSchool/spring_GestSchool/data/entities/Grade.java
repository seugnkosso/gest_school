package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "grades")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grade extends AbstractEntity {
    private String libelle;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Grade_Professeur",
            joinColumns = { @JoinColumn(name = "grade_id") },
            inverseJoinColumns = { @JoinColumn(name = "professeur_id") }
    )
    private List<Professeur> listeProfesseur;
}
