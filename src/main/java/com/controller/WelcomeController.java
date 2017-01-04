package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Main Server on 04.01.2017.
 */
@Controller
@RequestMapping(value = "/")
public class WelcomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String welcomePage(){
        return "index";
    }
}
