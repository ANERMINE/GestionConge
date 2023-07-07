package com.gesconge.gesconge.Entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;




@Getter
@Setter
@Entity

@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name = "employees", uniqueConstraints = {
@UniqueConstraint(columnNames = "username"),
@UniqueConstraint(columnNames = "email")
    })
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Emp ;

    String username;
    String nom;

    String prenom;
    String email;

    @NotBlank
    @Size(max = 120)
    String password;
    int Score;
    @Temporal(TemporalType.DATE)
    Date dateNaissance;
    @Temporal(TemporalType.DATE)
    Date dateEmbauche;
    @Temporal(TemporalType.DATE)
    Date dateSortie;
    @Enumerated(EnumType.STRING)
    TypeContrat typeContrat;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = " employee_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "Id_Role"))
    private Set<Role> roles = new HashSet<>();

    public Employee(){

    }
    @OneToMany(mappedBy = "Createur")
    Set<Conge> CongePris;
    @OneToMany(mappedBy = "Validateur")
    Set<Conge> CongeTraite;
    @ManyToOne
    Equipe equipe;
    @OneToMany(mappedBy = "Redacteur")
    Set<Commentaire>ListCommentaire;
    @OneToMany(mappedBy = "employee")
    private Set<Reclamation>reclamations;


    public Employee(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
