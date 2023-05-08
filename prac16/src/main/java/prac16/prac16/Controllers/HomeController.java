package prac16.prac16.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/home", produces = "text/html")
    public String home() {
        return "home.html";
    }
}