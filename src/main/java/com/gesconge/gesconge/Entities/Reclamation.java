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
public class Reclamation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idReclamation;
    @Enumerated(EnumType.STRING)
    TypeReclamation type;
    @Temporal(TemporalType.DATE)
    Date dateCreation;
    @Enumerated(EnumType.STRING)
    EtatReclamation etat;


    @ManyToOne
    Employee employee;
}
