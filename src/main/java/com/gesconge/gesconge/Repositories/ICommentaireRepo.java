package com.gesconge.gesconge.Repositories;

import com.gesconge.gesconge.Entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentaireRepo extends JpaRepository<Commentaire,Long> {
}
