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
public class Score {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long Id_score;
    Float Note;
    @Temporal(TemporalType.DATE)
    Date DateScore;
    @Temporal(TemporalType.TIME)
    Date Heure;
    @ManyToOne
    Employee salarie; //celui qui attribue un score ou bien celui qui posséde un score
}
