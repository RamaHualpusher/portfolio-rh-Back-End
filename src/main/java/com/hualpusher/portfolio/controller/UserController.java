package com.hualpusher.portfolio.controller;

import com.hualpusher.portfolio.dto.*;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "https://portfolio-ramiro-hualpa.web.app")
public class UserController {

    @Value("${app.admin.username}")
    private String adminUsername;

    @Value("${app.admin.password}")
    private String adminPassword;
    private final PersonHeaderServiceImpl personHeaderService;
    private final UserAboutMeServiceImpl userAboutMeService;
    private final UserContactServiceImpl userContactService;
    private final UserFullNameServiceImpl userFullNameService;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(PersonHeaderServiceImpl personHeaderService,
                          UserAboutMeServiceImpl userAboutMeService,
                          UserContactServiceImpl userContactService,
                          UserFullNameServiceImpl userFullNameService,
                          UserServiceImpl userService) {
        this.personHeaderService = personHeaderService;
        this.userAboutMeService = userAboutMeService;
        this.userContactService = userContactService;
        this.userFullNameService = userFullNameService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = userService.convertToEntity(userDto);
        User createdUser = userService.save(user);
        return ResponseEntity.ok(userService.convertToDto(createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Login login) {
        boolean usernameMatches = adminUsername.equals(login.getUsername());
        boolean passwordMatches = adminPassword.equals(login.getPassword());

        if (!usernameMatches || !passwordMatches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(userService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.findAll().stream()
                .map(userService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.findById(id)
                .map(user -> {
                    User updatedUser = userService.convertToEntity(userDto);
                    updatedUser.setId(id);
                    return userService.save(updatedUser);
                })
                .map(userService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    //*************CONTROLADORES PARA LOS DISTINTOS DTO DERIVADOS DE USER*************//

    @PatchMapping("/update/fulluser/{id}")
    public ResponseEntity<UserDto> updateFullUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.findById(id)
                .map(user -> {
                    User updatedUser = userService.convertToEntity(userDto);
                    updatedUser.setId(id); // asegúrate de mantener el mismo ID
                    return userService.save(updatedUser);
                })
                .map(userService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/personheader/{id}")
    public ResponseEntity<PersonHeaderDto> updatePersonHeader(@PathVariable Long id, @RequestBody PersonHeaderDto personHeaderDto) {
        return personHeaderService.findById(id)
                .map(user -> {
                    User updatedUser = personHeaderService.convertToEntity(personHeaderDto);
                    updatedUser.setId(id); // asegúrate de mantener el mismo ID
                    return personHeaderService.save(updatedUser);
                })
                .map(personHeaderService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/aboutme/{id}")
    public ResponseEntity<UserAboutMeDto> updateAboutMe(@PathVariable Long id, @RequestBody UserAboutMeDto userAboutMeDto) {
        return userAboutMeService.findById(id)
                .map(user -> {
                    User updatedUser = userAboutMeService.convertToEntity(userAboutMeDto);
                    updatedUser.setId(id); // asegúrate de mantener el mismo ID
                    return userAboutMeService.save(updatedUser);
                })
                .map(userAboutMeService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/contact/{id}")
    public ResponseEntity<UserContactDto> updateContact(@PathVariable Long id, @RequestBody UserContactDto userContactDto) {
        return userContactService.findById(id)
                .map(user -> {
                    User updatedUser = userContactService.convertToEntity(userContactDto);
                    updatedUser.setId(id); // asegúrate de mantener el mismo ID
                    return userContactService.save(updatedUser);
                })
                .map(userContactService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/fullname/{id}")
    public ResponseEntity<UserFullNameDto> updateFullName(@PathVariable Long id, @RequestBody UserFullNameDto userFullNameDto) {
        return userFullNameService.findById(id)
                .map(user -> {
                    User updatedUser = userFullNameService.convertToEntity(userFullNameDto);
                    updatedUser.setId(id); // asegúrate de mantener el mismo ID
                    return userFullNameService.save(updatedUser);
                })
                .map(userFullNameService::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
