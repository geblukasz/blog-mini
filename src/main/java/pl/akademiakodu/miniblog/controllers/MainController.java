package pl.akademiakodu.miniblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.miniblog.model.entities.Post;
import pl.akademiakodu.miniblog.model.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private PostRepository postRepository;

    @GetMapping("/")
    public String getIndexPage(Model model){
        model.addAttribute("name", "Jarek");
        return "index";
    }

    @PostMapping("/addPost")
    public String addPost(Model model, @RequestParam (value = "title") String titleParam, @RequestParam String content){
        System.out.println("Params: " + titleParam + ", " + content);
        Post post = new Post(titleParam, content);
        postRepository.save(post);
        return "index";
    }

    @GetMapping("/addPost")
    public String addPostPage(){
        return "addPost";
    }

    @GetMapping("/posts")
    public String postsPage(Model model){
        List<Post> postsList = new ArrayList<>();
        Iterable<Post> postIterable = postRepository.findAll();

        for (Post post : postIterable) {
            postsList.add(post);
        }

        model.addAttribute("posts", postsList);
        return "posts";
    }

    @GetMapping("/posts/{title}")
    public String postsByTitle(@PathVariable String title, Model model){
        List<Post> postsList = new ArrayList<>();
        Iterable<Post> postIterable = postRepository.findAllByTitleContains(title);
        for (Post post : postIterable) {
            postsList.add(post);
        }
        model.addAttribute("posts", postsList);
        return "posts";
    }

    @GetMapping("/posts/{title}/{sortField}")
    public String postsByTitle(@PathVariable String title
            , @PathVariable String sortField
            , Model model){
        List<Post> postsList = postRepository
                .findAllByTitleContains(title, Sort.by(Sort.Direction.ASC, sortField));
        model.addAttribute("posts", postsList);
        return "posts";
    }

    @Autowired
    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
