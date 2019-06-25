package com.zygstore.controllers;

import java.util.Map;


import com.sun.faces.action.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

@Controller
public class AdminController {

@RequestMapping("/admin")
    public String adminPage(Map<String, Object> model){
        model.put("message", "HowToDoInJava Reader !!");
        return "admin";
    }
}
