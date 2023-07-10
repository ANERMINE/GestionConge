package com.gesconge.gesconge.Services;


import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Repositories.IPostRepo;
import com.gesconge.gesconge.Entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
@Service
@AllArgsConstructor
public class PostService implements IPostService {

    private IPostRepo postREPO;
    @Override
    public List<Post> retrieveAllPosts() {
        return postREPO.findAll();
    }

    @Override
    public Post retrievePost(Long id) {
        return postREPO.findById(id).get();
    }

    @Override
    public Post addPost(Post p) {
        return postREPO.save(p);
    }

    @Override
    public Post updatePost(Post P) {
        Long postId = P.getId_post(); // Récupérer l'ID du post
        Post existingPost = postREPO.findById(postId).orElse(null); // Récupérer le post existant par son ID

        if (existingPost != null) {
            // Mettre à jour les propriétés du post existant avec les valeurs de P
            existingPost.setDescription(P.getDescription());
            existingPost.setDatePublication(P.getDatePublication());

            // Enregistrer les modifications
            return postREPO.save(existingPost);
        }

        return null; // Gérer le cas où le post n'existe pas
    }


    @Override
    public void deletePost(Long id) {
         postREPO.deleteById(id);
    }

    @Override
    public Post createPost(Long employeeId, Post post) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        post.setEmployees(employee);
        return postREPO.save(post);
    }
}
