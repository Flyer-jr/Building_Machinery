package com.fly.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/add")
    public String showAddPage() {
        return "addNewUserForm";

    }
    @RequestMapping("/list")
    public String showListPage(){
        return "listpage";
    }
}
