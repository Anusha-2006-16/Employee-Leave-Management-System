package com.employee.Employee_Leave_Management.controller;

import com.employee.Employee_Leave_Management.entity.LeaveRequest;
import com.employee.Employee_Leave_Management.service.LeaveRequestService;
import com.employee.Employee_Leave_Management.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;
    private final LeaveRequestService  leaveRequestService;
    @Autowired
    public ManagerController(ManagerService managerService,LeaveRequestService  leaveRequestService) {
        this.managerService = managerService;
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping("/dashboard")
    public String managerDashboard(Model model) {
        return "managerDashboard";
    }

    @GetMapping("/viewAllrequests")
    public String viewAllRequests(Model model) {
        List<LeaveRequest> requests=leaveRequestService.getAllRequests();
        model.addAttribute("requests",requests);
        return "viewAllRequestsByManager";
    }
//    @{/manager/changeEmpAppr/{request}(request=${request}})}
@GetMapping("/changeEmpAppr/{id}")
public String changeEmpAppr(@PathVariable Long id, Model model) {
    LeaveRequest request = leaveRequestService.getById(id);
    model.addAttribute("request", request); // only "request" exists
    return "changeEmpApprForm";
}

    @PostMapping("/changeEmpAppr/{id}")
    public String changeEmpApproval(
            @PathVariable Long id,
            @ModelAttribute("leaveRequest") LeaveRequest leaveRequest
    ) {
        leaveRequestService.updateEmployeeApproval(
                id,
                leaveRequest.getStatus(),
                leaveRequest.getManagerComment()
        );
        return "redirect:/manager/viewAllrequests";
    }
}
