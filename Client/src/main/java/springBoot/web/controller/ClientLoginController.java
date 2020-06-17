package springBoot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springBoot.web.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class ClientLoginController {

    UserService userService;

    @Autowired
    public ClientLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/*")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/panel")
    public String getTable(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "table";
    }
}

