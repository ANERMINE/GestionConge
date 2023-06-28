package com.gesconge.gesconge.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Justificatif  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int Id_just;
    private String libelle;

    @Lob
    private byte[] pdf;

}
