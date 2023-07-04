package com.gesconge.gesconge.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long Id_post;
    String description;
    @Temporal(TemporalType.DATE)
    Date datePublication;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
    @JsonIgnore
    Set<Comment> listCommentaire;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Employee employees;

}
