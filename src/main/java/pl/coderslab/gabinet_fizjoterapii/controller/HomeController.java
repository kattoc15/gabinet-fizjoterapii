package pl.coderslab.gabinet_fizjoterapii.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    public String homePage() {
        return "index";
    }
}