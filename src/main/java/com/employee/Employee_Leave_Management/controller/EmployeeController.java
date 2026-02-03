package com.employee.Employee_Leave_Management.controller;

import com.employee.Employee_Leave_Management.entity.Employee;
import com.employee.Employee_Leave_Management.entity.LeaveRequest;
import com.employee.Employee_Leave_Management.repository.EmployeeRepository;
import com.employee.Employee_Leave_Management.service.EmployeeService;
import com.employee.Employee_Leave_Management.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final LeaveRequestService leaveRequestService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, LeaveRequestService leaveRequestService) {
        this.employeeService = employeeService;
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping("/dashboard")
    public String employeeDashboard() {
        return "employeeDashboard";
    }

    @GetMapping("/leaveForm")
    public String employeeLeaveForm(Model model, Authentication authentication) {

        String email = authentication.getName(); // logged-in email
        Employee employee = employeeService.findByEmail(email); // handle Optional inside service

        model.addAttribute("employee", employee);
        model.addAttribute("leaveRequest", new LeaveRequest());

        return "LeaveForm";
    }

    @PostMapping("/leaveForm")
    public String applyLeaveRequest(
            @ModelAttribute("leaveRequest") LeaveRequest leaveRequest,
            Authentication authentication) {

        String email = authentication.getName();
        Employee employee = employeeService.findByEmail(email); // unwrapped

        leaveRequest.setEmployee(employee);
        employeeService.applyRequest(leaveRequest);

        return "redirect:/employee/viewLeaves";
    }

    @GetMapping("/viewLeaves")
    public String getMyLeaves(Authentication authentication, Model model) {
        String email = authentication.getName();
        Employee employee = employeeService.findByEmail(email);

        List<LeaveRequest> requests = leaveRequestService.findByEmployee(employee);
        model.addAttribute("requests", requests);

        return "viewLeaves";
    }

}
