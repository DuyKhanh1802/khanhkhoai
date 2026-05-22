package controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
