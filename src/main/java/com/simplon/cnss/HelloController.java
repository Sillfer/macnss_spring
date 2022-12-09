package com.simplon.cnss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        ModelAndView mv = new ModelAndView();
        mv.addObject(name);
        return "home";
    }

    @RequestMapping("/admin/dashboard")
    public String home(){
        return "agent/home";
    }
}
