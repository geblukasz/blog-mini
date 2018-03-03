package pl.akademiakodu.miniblog.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.miniblog.model.entities.User;
import pl.akademiakodu.miniblog.model.forms.RegisterForm;
import pl.akademiakodu.miniblog.model.repositories.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid RegisterForm registerForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "register";
        }

        User user = (new ModelMapper()).map(registerForm, User.class);
        userRepository.save(user);
        return "index";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }
}
