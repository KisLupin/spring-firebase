package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFirebase {
    @GetMapping("/get")
    public String get(){
        return "Hello";
    }
    @GetMapping("/all")
    public String all(){
        return "Success";
    }
}
