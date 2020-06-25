package springBoot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientLoginController {

    @GetMapping("/*")
    public String loginPage() {
        return "login";
    }
}

