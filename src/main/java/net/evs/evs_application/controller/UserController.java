package net.evs.evs_application.controller;

import net.evs.evs_application.model.User;
import net.evs.evs_application.services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

 @PostMapping("/register")
public ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody User user, BindingResult result) {
    Map<String, Object> response = new HashMap<>();

    // Validation errors
    if (result.hasErrors()) {
        response.put("message", "Validation failed");
        response.put("status", "error");
        response.put("errors", result.getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList());
        response.put("code", 400);
        return ResponseEntity.badRequest().body(response);
    }

    // Handle duplicate email or other business logic
    try {
        User savedUser = userService.registerUser(user);

        Map<String, Object> data = new HashMap<>();
        data.put("firstName", savedUser.getFirstName());
        data.put("lastName", savedUser.getLastName());
        data.put("email", savedUser.getEmail());

        response.put("message", "User registered successfully");
        response.put("status", "success");
        response.put("data", data);
        response.put("code", 200);
        return ResponseEntity.ok(response);

    } catch (Exception e) {
        response.put("message", e.getMessage());
        response.put("status", "error");
        response.put("code", 400); // Bad request instead of Internal Server Error
        return ResponseEntity.badRequest().body(response);
    }
}

}

