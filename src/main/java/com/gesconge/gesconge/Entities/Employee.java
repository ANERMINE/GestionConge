package com.gesconge.gesconge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Emp ;
    String username;
    String nom;
    String prenom;
    String MotDePasse;
    int Score;
    Float solde;
    @Temporal(TemporalType.DATE)
    Date dateNaissance;
    @Temporal(TemporalType.DATE)
    Date dateEmbauche;
    @Temporal(TemporalType.DATE)
    Date dateSortie;
    @Enumerated(EnumType.STRING)
    TypeContrat typeContrat;
    @JsonIgnore
    @ManyToOne
    Role role;
    @JsonIgnore
    @OneToMany(mappedBy = "Createur")
    Set<Conge> CongePris;
    @JsonIgnore
    @OneToMany(mappedBy = "Validateur")
    Set<Conge> CongeTraite;
    @JsonIgnore
    @ManyToOne
    Equipe equipe;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Employee responsable;
    @JsonIgnore
    @OneToMany(mappedBy = "responsable")
    private List<Employee> employeesSupervises;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    Set<Comment> listCommentaires;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Set<Reclamation>reclamations;
    @JsonIgnore
    @OneToMany(mappedBy = "salarie")
    private List<Score> score_donnees;
    @JsonIgnore
    @OneToMany(mappedBy = "salarie")
    private List<Score> score_posedees;
    @JsonIgnore
    @OneToMany(mappedBy = "salarie")
    private List<Pointage> pointages;








}
