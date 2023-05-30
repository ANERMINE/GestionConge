package com.gesconge.gesconge.Repositories;


import com.gesconge.gesconge.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
