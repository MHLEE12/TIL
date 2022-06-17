package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // localhost가 호출되면 이것이 호출된다.
   public String home() {
        return "home";
    }
}
