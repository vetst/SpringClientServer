package springBoot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import springBoot.web.model.UserDTO;
import springBoot.web.util.ObjectEntityConversion;


import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private ObjectEntityConversion objectEntityConversion;

    @Autowired
    public void setUtilService(ObjectEntityConversion objectEntityConversion) {
        this.objectEntityConversion = objectEntityConversion;
    }

    @Override
    public ResponseEntity<String> getAllUsers() {
        return restTemplate.getForEntity("/admin/users", String.class);
    }

    @Override
    public void addUser(UserDTO userDTO) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);
        restTemplate.postForObject("/admin/addUser", entity, UserDTO.class);
    }

    @Override
    public void removeUser(UserDTO userDTO) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);
        restTemplate.postForObject("/admin/remove", entity, UserDTO.class);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);
        restTemplate.postForObject("/admin/update", entity, UserDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);
        return objectEntityConversion.convert(Objects.requireNonNull(restTemplate.exchange("/getUser?email=" + email,
                HttpMethod.POST,
                request,
                UserDTO.class)
                .getBody()));
    }
}
