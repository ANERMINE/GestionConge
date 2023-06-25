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
    String nom;
    String prenom;
    String MotDePasse;
    int Score;
    @Temporal(TemporalType.DATE)
    Date dateNaissance;
    @Temporal(TemporalType.DATE)
    Date dateEmbauche;
    @Temporal(TemporalType.DATE)
    Date dateSortie;
    @Enumerated(EnumType.STRING)
    TypeContrat typeContrat;
    @ManyToOne
    Role role;
    @OneToMany(mappedBy = "Createur")
    Set<Conge> CongePris;
    @OneToMany(mappedBy = "Validateur")
    Set<Conge> CongeTraite;
    @ManyToOne
    Equipe equipe;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    Set<Comment> listCommentaires;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Set<Reclamation>reclamations;
    @OneToMany(mappedBy = "salarie")
    private List<Score> score_données;
    @OneToMany(mappedBy = "salarie")
    private List<Score> score_posedées;
    @OneToMany(mappedBy = "salarie")
    private List<Pointage> pointages;








}
