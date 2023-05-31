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
    Type type;
    @Temporal(TemporalType.DATE)
    Date dateCreation;
    EtatReclamation etat;

    enum Type{DeclarationDeProbleme,Feedback,DemandeSoldeConge}
enum EtatReclamation{Traitee, NonTraitee}

    @ManyToOne
    Employee employee;
}
