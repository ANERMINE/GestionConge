package Entities;

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
public class Equipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_Equipe;
    String codeEquipe;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "equipe")
    Set<Employee> ListEmployee;
}
