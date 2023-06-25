package com.gesconge.gesconge.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Conge;
    float solde;
    @Temporal(TemporalType.DATE)
    Date dateDebut;
    @Temporal(TemporalType.DATE)
    Date dateFin;
    @Enumerated(EnumType.STRING)
    EtatConge Etat;
    @Enumerated(EnumType.STRING)
    NatureConge Nature;
    @ManyToOne

    Employee Createur;

    @ManyToOne
    //@JoinColumn(name = "Id_Valideur")
    Employee Validateur;






}
