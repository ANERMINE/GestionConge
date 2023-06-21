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
public class Pointage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long Id_pointage;
    @Temporal(TemporalType.DATE)
    Date date;
    @Temporal(TemporalType.TIME)
    Date Heure_entree;
    @Temporal(TemporalType.TIME)
    Date Heure_Sortie;
    @ManyToOne
    Employee salarie;
}
