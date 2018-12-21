package com.example.appdemo.mainController;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class MainPageController {

    @GET
    @RequestMapping(value = {"/", "/index"})
    public String showMainPage() {
        return "index";
    }
}
