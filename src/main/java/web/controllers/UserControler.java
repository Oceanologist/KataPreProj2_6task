package web.controllers;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserControler {

    @GetMapping(value="/")
    public String viewAllUsers(){

        return null;
    }
    @PostMapping(value="_______/")
    public String addUser(User user){

        return null;
    }
    @GetMapping("/")
    public String updateUser(){

        return null;
    }
    @GetMapping("/")
    public String deleteUser(){

        return null;
    }

}
