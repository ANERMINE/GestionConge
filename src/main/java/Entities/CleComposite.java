package Entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CleComposite implements Serializable {
    private long id_Post;
    private long id_Employee;
    private long id_Commentaire;

}
