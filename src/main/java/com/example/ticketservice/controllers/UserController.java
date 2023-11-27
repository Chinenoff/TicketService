package com.example.ticketservice.api;

import com.example.ticketservice.entity.User;
import com.example.ticketservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    // For the sake of simplicity, let's use a static list


    @GetMapping
    public String fullGreeting(@RequestParam("id") Long id,
                               @RequestParam("surname") String surname) {
        return "Nice to meet you, " + id + " " + surname;
    }

    @GetMapping("/{id}")
    public String greetWithPathVariable(@PathVariable("id") Long id) {
        return "Hello, " + id;
    }

    /*@GetMapping
    //@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLoginTest(@RequestParam("id") Long id) {
        LOGGER.debug("Finding number of seats available for level {}", id);
        System.out.println(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    /*@GetMapping("/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable("login") String login) {
        System.out.println("TEST********************");
        System.out.println(login);
        User user = userService.findByLogin(login);
        System.out.println("TEST********************");
        System.out.println(user);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @PostMapping("/createuser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            /*tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));*/
            return new ResponseEntity<>("User was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /* public void createUser(String login, String password, String firstName, String lastName,
                           String middleName) {
        userRepository.createUser(login, password, firstName, lastName, middleName);
    }*/

   /* @PostMapping(value = "/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {

            tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
   /* public ResponseEntity<?> create(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

    /*public static final int GAS = 1;
    public static final int AIRPLANE = 1;
    public boolean canTransferGas(Cargo cargo, Transport transport){
        return !(cargo.getType == GAS && transport.getType == AIRPLANE);
    }*/
}
