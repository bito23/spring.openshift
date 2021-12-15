package spring.openshift.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index(){
        return "This is a hello world message received from Openshifit!";
    }
}
