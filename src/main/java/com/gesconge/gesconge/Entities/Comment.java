package com.gesconge.gesconge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long IdComment;
    String contenu;
    @Temporal(TemporalType.DATE)
    Date datePublication;
    @ManyToOne
    @JsonIgnore
    Employee employee;
    @ManyToOne
    @JsonIgnore
    Post post;
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
