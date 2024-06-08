package com.spring_GestSchool.spring_GestSchool.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "filieres")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filliere extends AbstractEntity {
    private String libelle;
    @OneToMany(mappedBy = "filiere")
    private List<Classe> listeClasse;
}
