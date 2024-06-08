package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Salles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Salle extends AbstractEntity {
    private String libelle;
    private Long numero;
    private Long nbrPlace;
    @OneToMany(mappedBy = "salle")
    private List<SessionCour> listeSessionCour;
}
