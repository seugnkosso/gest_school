package com.spring_GestSchool.spring_GestSchool.data.entities;

import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "attachers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("Attacher")
public class Attacher extends AppUser {
    @OneToMany(mappedBy = "attacher")
    private List<Classe> listeClasse;
}
