package prac15.prac15.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping(value = "/home", produces = "text/html")
    public String home() {
        return "home.html";
    }
}