package com.spring_GestSchool.spring_GestSchool.data.entities;

import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Absences")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Absence extends AbstractEntity {
    @Embedded
    private Justification justication;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private SessionCour sessionCour;

}
