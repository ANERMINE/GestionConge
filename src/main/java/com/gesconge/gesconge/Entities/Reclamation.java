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
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idReclamation;
    @Enumerated(EnumType.STRING)
    TypeReclamation type;
    @Temporal(TemporalType.DATE)
    Date dateCreation;
    @Enumerated(EnumType.STRING)
    EtatReclamation etat;
    String pieceJointe;
    private float nbJours;

    public float getnbJours() {
        return nbJours;
    }

    public void setnbJours(float nbJours) {
        this.nbJours = nbJours;
    }


    @ManyToOne
    Employee employee;
}
