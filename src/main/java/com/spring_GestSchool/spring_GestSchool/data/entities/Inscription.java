package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "inscriptions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inscription extends AbstractEntity {
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private AnneeScollaire anneeScolaire;
}
