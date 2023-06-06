package com.gesconge.gesconge.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Equipe;
    String codeEquipe;
    @OneToMany(mappedBy = "equipe")
    Set<Employee> ListEmployee;
    @OneToMany(mappedBy = "equipe")
    Set<Evenement>ListEvenements;

}
