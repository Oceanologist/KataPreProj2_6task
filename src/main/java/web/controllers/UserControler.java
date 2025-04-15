package web.controllers;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/people")
public class UserControler {
    private UserService userService;

    UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String viewAllUsers(Model model) {
        model.addAttribute("users", userService.viewAllUsers());
        return "people/allUsers";
    }

    @PostMapping(value = "/new")
    //форма для создания нового юзера
    public String addUser(User user) {

        return null;
    }

    @PatchMapping("/:id/edit")
    //форма редактирования записи
    public String updateUser() {

        return null;
    }

    @DeleteMapping("/:id")
    public String deleteUser() {

        return null;
    }

}
