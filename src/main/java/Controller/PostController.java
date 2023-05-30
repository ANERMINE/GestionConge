package Controller;

import Entities.Post;
import Services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Post")

public class PostController {

    @Autowired
    private IPostService postService;

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

    @PostMapping("/addPost")
    @ResponseBody
    public Post addPost(Post p) {
        return postService.addPost(p);
    }

    @PutMapping("/update/Post")
    @ResponseBody
    public Post updatePost(Post P) {
        return postService.updatePost(P);
    }

    @DeleteMapping("/delete/{id-Post}")
    @ResponseBody
    public void deletePost(Long id) {
        postService.deletePost(id);
    }

}
