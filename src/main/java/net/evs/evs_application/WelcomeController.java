package net.evs.evs_application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to EVS Application!";
    }   
     @GetMapping("/hello")
    public String test() {
        return "this is to test the development progress of e-visitor sysrem develpment";
    }   
    

}
