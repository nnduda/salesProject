package pl.edu.wszib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RegisterController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
