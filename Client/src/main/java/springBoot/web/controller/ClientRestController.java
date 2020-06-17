package springBoot.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBoot.web.model.User;
import springBoot.web.model.UserDTO;
import springBoot.web.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/*")
public class ClientRestController {

    private UserService userService;

    @Autowired
    public ClientRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public ResponseEntity<String> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/admin/remove")
    public ResponseEntity<User> removeUser(@RequestParam Long id) {
        userService.removeUser(new UserDTO(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/update")
    public ResponseEntity<User> updateUser(@RequestParam Long id, String firstName, String password, String lastName, String email, int age, String role) {
        userService.updateUser(new UserDTO(id, firstName, lastName, email, age, password, role));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/addUser")
    public ResponseEntity<User> addUser(@RequestParam String firstName, String password, String lastName, String email, int age, String role) {
        UserDTO userDTO = new UserDTO(firstName, lastName, email, age, password, role);
        userService.addUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/getUser")
    public ResponseEntity<List<User>> getUser(HttpSession session) {
        List<User> userList = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        userList.add(user);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}