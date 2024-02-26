package com.example.ManyToManyDemo.Controller;

import com.example.ManyToManyDemo.Service.RestaurantSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
