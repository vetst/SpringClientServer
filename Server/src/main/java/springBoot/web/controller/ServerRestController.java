package springBoot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBoot.web.model.User;
import springBoot.web.model.UserDTO;
import springBoot.web.service.InitService;
import springBoot.web.service.UserService;
import springBoot.web.util.DtoToEntity;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class ServerRestController {

    private UserService service;
    private InitService initService;
    private DtoToEntity dtoToEntity;

    @Autowired
    public void setUtilService(DtoToEntity dtoToEntity) {
        this.dtoToEntity = dtoToEntity;
    }

    @Autowired
    public void setInitService(InitService initService) {
        this.initService = initService;
    }

    @Autowired
    public ServerRestController(UserService service) {
        this.service = service;
    }

    @PostMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam String email) {
        initService.addAdminAndUser();
        return new ResponseEntity<>(service.getUserByName(email), HttpStatus.OK);
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/admin/remove")
    public ResponseEntity<User> removeUser(@RequestBody UserDTO userDTO) {
        service.removeUser(userDTO.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/update")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userDTO.setPassword(service.ifPasswordNull(userDTO.getId(), userDTO.getPassword()));
        service.updateUser(dtoToEntity.convert(userDTO));
    }

    @PostMapping("/admin/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        service.addUser(dtoToEntity.convert(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}