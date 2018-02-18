package pl.akademiakodu.miniblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademiakodu.miniblog.model.entities.Post;
import pl.akademiakodu.miniblog.model.repositories.PostRepository;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/post/{postId}")
    public String post(@PathVariable Long postId, Model model){
        Optional<Post> postOptional = postRepository.findById(postId);

        postOptional.ifPresent(post -> {
            model.addAttribute("post", post);
        });

        return "post";
    }
}
