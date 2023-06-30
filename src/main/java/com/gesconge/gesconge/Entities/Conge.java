package com.gesconge.gesconge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Temporal(TemporalType.DATE)
    Date dateDebut;
    @Temporal(TemporalType.DATE)
    Date dateFin;
    @Enumerated(EnumType.STRING)
    EtatConge Etat;
    @Enumerated(EnumType.STRING)
    NatureConge Nature;
    @JsonIgnore
    @ManyToOne
    Employee Createur;
    @JsonIgnore
    @ManyToOne
    Employee Validateur;






}
