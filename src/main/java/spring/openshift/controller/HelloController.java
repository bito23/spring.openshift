package spring.openshift.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HelloController {
    public String index(Model model) {
        model.addAttribute("message", "This is a hello world message received from Openshift!");
        return "index";
    }
}
