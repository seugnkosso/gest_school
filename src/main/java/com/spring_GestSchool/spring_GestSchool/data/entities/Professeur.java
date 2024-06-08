package com.spring_GestSchool.spring_GestSchool.data.entities;

import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "professeurs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("Professeur")
public class Professeur extends AppUser {
    @OneToMany(mappedBy = "professeur")
    private List<Cour>  listeCour;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listeProfesseur")
    private List<Grade> listeGrade;
    @ManyToOne
    private Spécialite spécialite;
}
