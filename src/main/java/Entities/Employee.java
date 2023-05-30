package Entities;

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
    String nom;
    String prenom;
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
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "Createur")
    Set<Conge> CongePris;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "Validateur")
    Set<Conge> CongeTraite;
    @ManyToOne
    Equipe equipe;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "Redacteur")
    Set<Commentaire>ListCommentaire;







}