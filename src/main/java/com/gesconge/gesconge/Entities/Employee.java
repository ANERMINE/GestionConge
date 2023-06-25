package com.gesconge.gesconge.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Emp ;
    String persoId;
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
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL,mappedBy = "Redacteur")
    Set<Commentaire>ListCommentaire;
    @OneToMany(mappedBy = "employee")
    private Set<Reclamation>reclamations;
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Employee responsable;







}
