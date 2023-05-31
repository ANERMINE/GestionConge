package Services;


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
        return postREPO.save(P);
    }

    @Override
    public void deletePost(Long id) {
         postREPO.deleteById(id);
    }
}
