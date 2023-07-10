package com.gesconge.gesconge.Controller;


import com.gesconge.gesconge.Entities.Comment;
import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Services.ICommentService;
import com.gesconge.gesconge.Services.IPostService;
import com.gesconge.gesconge.Entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Post")

public class PostController {

    @Autowired
    private IPostService postService;
    @Autowired
    private ICommentService commentService;

    @GetMapping("/Comments/{id}")
    @ResponseBody
    public List<Comment> getCommentsByPost(@PathVariable("id") Long Id_Post) {
        return commentService.getallcommentsByPost(Id_Post);
    }


    @GetMapping("/allPosts")
    @ResponseBody
    public List<Post> retrieveAllPosts() {
        return postService.retrieveAllPosts();
    }

    @GetMapping("/PostByID/{id-Post}")
    @ResponseBody
    public Post retrievePost(@PathVariable("id-Post") Long id) {
        return postService.retrievePost(id);
    }
    @PostMapping("/{employeeId}")
    public Post createPost(@PathVariable("employeeId") Long employeeId, @RequestBody Post post) {
        return postService.createPost(employeeId, post);
    }


    @PostMapping("/addPost")
    @ResponseBody
    public Post addPost(@RequestBody  Post p) {
        return postService.addPost(p);
    }

    @PutMapping("/update/{idPost}")
    @ResponseBody
    public Post updatePost(@RequestBody Post post, @PathVariable("idPost") Long id) {
        post.setId_post(id); // Mettre à jour l'ID du post
        return postService.updatePost(post);
    }


    @DeleteMapping("/delete/{id-Post}")
    @ResponseBody
    public void deletePost(@PathVariable("id-Post") Long id) {
        postService.deletePost(id);
    }




}
