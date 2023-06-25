package com.gesconge.gesconge.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Commentaire {
    //@EmbeddedId
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id_Comment;
    String contenu;
    @Temporal(TemporalType.DATE)
    Date datePublication;
    @ManyToOne
    @JoinColumn(name="id_Emp",referencedColumnName = "Id_Emp",insertable = false,updatable = false)
    Employee Redacteur;
    @ManyToOne
    @JoinColumn(name="Id_post",referencedColumnName = "Id_post",insertable = false,updatable = false)
    Post post;



}
