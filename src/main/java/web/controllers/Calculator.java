package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping(value="/calculator")
    String getResult(@RequestParam(value="a") int a,@RequestParam(value="b") int b,@RequestParam(value = "action") String action, Model model){
       int answer=switch (action){
            case "addition"->a+b;
            case "multiplication"->a*b;
            case "subtraction"-> a-b;
            case "division"-> a/b;
           default -> throw new IllegalStateException("Unexpected value: " + action);
       };

       model.addAttribute("answer",answer);
       return "calculator";

    }
}
