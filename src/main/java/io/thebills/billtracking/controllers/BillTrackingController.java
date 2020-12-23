package io.thebills.billtracking.controllers;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.entities.UserEntity;
import io.thebills.billtracking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BillTrackingController {

    // setting up undefined userSerivce that is injected with dependencies in the constructor
    // which allows access to the UserService methods
    @Autowired
    private final UserService userService;

    public BillTrackingController(final UserService userService) {
        this.userService = userService;
    }

    // creating a route that returns
    @GetMapping("/user-details")
    public UserEntity getUserDetails(@RequestParam(name="email") String email) {
        System.out.println("getting user details by email in controller: " + email);
        return userService.getUserDetails(email);
    }

    @GetMapping("/all-users")
    // have tried List<User> and replaced all locations required according to error messages
    // same error message though... "User is not mapped" even when I switch to UserEntity
    // https://stackoverflow.com/questions/14446048/hibernate-table-not-mapped-error-in-hql-query
    // QUESTION: How do I map User?
    //      A: Issue had to do with query string
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/new-user")
    public User saveNewUser(@RequestBody User user) {
        userService.createUser(user);
        // todo: only return user here if user was successfully saved to db
        // NOTE: returning user here as was passed by the original post request
        //  user is not a response object, if there was one it would be of the UserEntity Type?
        return user;
    }

    @PostMapping("/update-user")
    public UserEntity updateUser(@RequestBody User updatedUser) {
        // QUESTION: What is best way to handle when user puts in email not found in db?
        return userService.updateUser(updatedUser.getEmail(), updatedUser);
    }

    @DeleteMapping("/delete-user")
    public void deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
    }
}
