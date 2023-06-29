package com.gesconge.gesconge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Role;
    String Libelle;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    Set<Employee> ListEmployee;

}
