package Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long Id_post;
    String description;
    @Temporal(TemporalType.DATE)
    Date datePublication;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
    Set<Commentaire> ListCommentaire;

}
