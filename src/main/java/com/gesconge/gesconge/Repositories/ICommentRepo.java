package com.gesconge.gesconge.Repositories;


import com.gesconge.gesconge.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment,Long> {
}
