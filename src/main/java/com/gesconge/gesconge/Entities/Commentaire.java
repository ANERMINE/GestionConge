package com.gesconge.gesconge.Entities;

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
public class Commentaire implements Serializable {
    @EmbeddedId
    CleComposite id_Comment;
    String contenu;
    @Temporal(TemporalType.DATE)
    Date datePublication;
    @ManyToOne
    Employee Redacteur;
    @ManyToOne
    Post post;



}
