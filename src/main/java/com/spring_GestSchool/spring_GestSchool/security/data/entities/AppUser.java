package com.spring_GestSchool.spring_GestSchool.security.data.entities;

import com.spring_GestSchool.spring_GestSchool.data.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "AppUser")
public class AppUser extends AbstractEntity {
    @Column(nullable = false, unique = true)
    protected String nomComplet;
    @Column(nullable = false, unique = true)
    protected String email;
    @Column(nullable = false, unique = true)
    protected String telephone;
    @Column(nullable = false, unique = true)
    protected String username;
    @Column(nullable = false)
    protected String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    protected List<AppRole> roles = new ArrayList<AppRole>();


}
