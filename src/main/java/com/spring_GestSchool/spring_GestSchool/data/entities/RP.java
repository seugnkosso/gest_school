package com.spring_GestSchool.spring_GestSchool.data.entities;

import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RP")
//@AllArgsConstructor
//@NoArgsConstructor
@Data
@DiscriminatorValue("RP")
public class RP extends AppUser {

}
