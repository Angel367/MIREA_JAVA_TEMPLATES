package prac14.prac14.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }
}