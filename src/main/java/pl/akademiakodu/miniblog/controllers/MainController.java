package pl.akademiakodu.miniblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.miniblog.model.repositories.PostRepository;

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

        return "index";
    }

    @GetMapping("/addPost")
    public String addPostPage(){
        return "addPost";
    }


    @Autowired
    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
