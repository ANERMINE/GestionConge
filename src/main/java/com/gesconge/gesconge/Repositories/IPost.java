package com.gesconge.gesconge.Repositories;


import com.gesconge.gesconge.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPost extends JpaRepository<Post,Long> {

}
