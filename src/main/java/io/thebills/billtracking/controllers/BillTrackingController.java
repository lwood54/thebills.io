package io.thebills.billtracking.controllers;

import io.thebills.billtracking.beans.User;
import io.thebills.billtracking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        // todo: get rid of these comments later
        // QUESTION: since we are using userService interface instead of implementation, how does the program
        // know to use the implementation, which it is clearly using?
            // A: it should have access to one bean, however when multiple are presented, then an identifier of
            // some sort needs to be used to inform which one needs to be used. See question below.
        // QUESTION: what happens if there are multiple implementations of an interface? which one will it use?
            // A: when attempted, failure to build, but gave possible actions:
                // 1. making one bean as @Primary
                    // - this worked great, but option 3 seems more explicit if I could get it to work
                    // - how would AltUserService ever get used this way?
                // 2. updating consumer to accept multiple beans (? - how would I do this?)
                // 3. using @Qaulifier to identify the bean that should be consumed.
                    // (resource: https://www.baeldung.com/spring-qualifier-annotation)
                    // - seems like best option, but I couldn't get to work
                        // - tried putting @Qualifier("UserServiceImpl") above private final UserService userService;
                        // - also tried putting them in the impl classes below @Service
    }

    @PostMapping("/new-user")
    public User saveNewUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }
}
