package com.employee.Employee_Leave_Management.controller;

import com.employee.Employee_Leave_Management.entity.Employee;
import com.employee.Employee_Leave_Management.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    public AdminService adminService;
    public UserController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("employee",new Employee());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute Employee employee){
        adminService.registerUser(employee);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

}
