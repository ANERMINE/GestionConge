package com.gesconge.gesconge.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "roles")
public class
Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Role;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleName name;


}
