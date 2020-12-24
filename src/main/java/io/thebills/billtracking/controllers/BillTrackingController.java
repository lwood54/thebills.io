package io.thebills.billtracking.controllers;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.entities.UserEntity;
import io.thebills.billtracking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RequestMapping("/api") would add the /api path in front of all of the paths grouped in this controller
@RestController
public class BillTrackingController {

    // setting up undefined userSerivce that is injected with dependencies in the constructor
    // which allows access to the UserService methods
    @Autowired
    private final UserService userService;

    public BillTrackingController(final UserService userService) {
        this.userService = userService;
    }

    // CREATE NEW USER
    @PostMapping("/new-user")
    public User saveNewUser(@RequestBody User user) {
        userService.createUser(user);
        // todo: only return user here if user was successfully saved to db
        return user;
    }

    // READ / Find Specified user by primary id: email
    @GetMapping("/user-details")
    public UserEntity getUserDetails(@RequestParam(name="email") String email) {
        UserEntity foundUser = userService.getUserDetails(email);
        if (foundUser == null) {
            throw new RuntimeException("There is no user with email: " + email);
        }
        return userService.getUserDetails(email);
    }

    // READ / Get list of all users
    @GetMapping("/all-users")
    // have tried List<User> and replaced all locations required according to error messages
    // same error message though... "User is not mapped" even when I switch to UserEntity
    // https://stackoverflow.com/questions/14446048/hibernate-table-not-mapped-error-in-hql-query
    // QUESTION: How do I map User?
    //      A: Issue had to do with query string
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    // UPDATE - update specified user by accessing with primary id: email
    @PostMapping("/update-user")
    public UserEntity updateUser(@RequestBody User updatedUser) {
        // QUESTION: What is best way to handle when user puts in email not found in db?
            // A (for now): check for return value, if not, throw Runtime Exception
        UserEntity foundUser = userService.getUserDetails(updatedUser.getEmail());
        if (foundUser == null) {
            throw new RuntimeException("The user specified with email, " + " does not exist.");
        }
        return userService.updateUser(updatedUser.getEmail(), updatedUser);
    }

    // DELETE - delete user by specified primary id: email
    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
        return "User with email: " + email + " has been deleted.";
    }
}
