package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SessionCours")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionCour extends AbstractEntity {
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "hh:mm")
    private Date heureDebut;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "hh:mm")
    private Date heureFin;
    private Long nbrHeure;
    private Boolean isValider = false;
    private String etat;
    @OneToMany(mappedBy = "sessionCour")
    private List<Absence> listeAbsence;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private Cour cour;
}
