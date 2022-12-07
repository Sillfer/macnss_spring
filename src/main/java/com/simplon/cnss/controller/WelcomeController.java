package com.simplon.cnss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        ModelAndView mv = new ModelAndView();
        mv.addObject(name);
        return "/agent/home";
    }

}
