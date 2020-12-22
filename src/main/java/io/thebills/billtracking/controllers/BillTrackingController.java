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

    @GetMapping("/user-details")
    public User getUserDetails(@RequestParam(name="username") String username) {
        return userService.getUserDetails(username);
    }

    @PostMapping("/new-user")
    public User saveNewUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }
}
