package com.gesconge.gesconge.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Conge implements Serializable {
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
    Employee Validateur;






}
