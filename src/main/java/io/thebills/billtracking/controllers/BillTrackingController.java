package io.thebills.billtracking.controllers;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillTrackingController {

    private final UserService userService;

    public BillTrackingController(final UserService userService) {
        this.userService = userService;
    }

    // creating a route that returns
    @GetMapping("/user-details")
    public User getUserDetails(@RequestParam(name="email") String email) {
        System.out.println("getting user details by email in controller: " + email);
        // todo: don't create new user, instead access user details from db
        return userService.getUserDetails(email);
    }

    @PostMapping("/new-user")
    public User saveNewUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }
}
