package com.employee.Employee_Leave_Management.controller;

import com.employee.Employee_Leave_Management.dto.UpdateEmployeeDTO;
import com.employee.Employee_Leave_Management.entity.Employee;
import com.employee.Employee_Leave_Management.entity.LeaveRequest;
import com.employee.Employee_Leave_Management.entity.Role;
import com.employee.Employee_Leave_Management.entity.Status;
import com.employee.Employee_Leave_Management.service.AdminService;
import com.employee.Employee_Leave_Management.service.EmployeeService;
import com.employee.Employee_Leave_Management.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EmployeeService employeeService;
    private final LeaveRequestService leaveRequestService;

    @Autowired
    public AdminController(EmployeeService employeeService,
                           LeaveRequestService leaveRequestService) {
        this.employeeService = employeeService;
        this.leaveRequestService = leaveRequestService;
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model){
        return "adminDashboard";
    }
    @GetMapping("/employees")
    public String employeesList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employeeList";
    }

    // SHOW UPDATE FORM
    @GetMapping("/updateEmp/{id}")
    public String updateEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "updateEmployeeForm";
    }

    // HANDLE UPDATE

    @PostMapping("/updateEmp")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/admin/employees";
    }
    // SHOW ALL (no filter)
    @GetMapping("/leaveRequests")
    public String allLeaveRequests(Model model) {
        model.addAttribute("requests", leaveRequestService.getAllRequests());
        model.addAttribute("statusFilter", false);
        return "viewAllRequestsByAdmin";
    }

    // FILTERED
    @GetMapping("/leaveRequests/{status}")
    public String leaveRequestsByStatus(@PathVariable Status status, Model model) {
        model.addAttribute("requests", leaveRequestService.getRequestsByStatus(status));
        model.addAttribute("statusFilter", true);
        return "viewAllRequestsByAdmin";
    }

    //CHANGE LEAVE REQUESTS BY ADMIN ===> @{/admin/changeEmpAppr/{id}(id=${request.id})}
    @GetMapping("/changeEmpAppr/{id}")
    public String changeEmployeeRequest(@PathVariable Long id,Model model){
        LeaveRequest request = leaveRequestService.getById(id);
        model.addAttribute("request",request);
        return "changeEmployeeFormByAdmin";
    }
    @PostMapping("/changeEmpAppr/{id}")
    public String changeEmployeeRequest(@ModelAttribute("request") LeaveRequest request,
                                        @PathVariable Long id){
        leaveRequestService.updateEmployeeApproval(
                id,
                request.getStatus(),
                request.getManagerComment()
        );
        return "redirect:/admin/leaveRequests";
    }
    //ANALYZE LEAVE REQUESTS ===>  /admin/analyzeRequests
    @GetMapping("/analyzeRequests")
    public String analyzeRequests(Model model){
        List<LeaveRequest> requests=leaveRequestService.getAllRequests();
        int leavesPending=leaveRequestService.getLeavesPending();
        int leavesApproved=leaveRequestService.getLeavesApproved();
        int leavesRejected=leaveRequestService.getLeavesRejected();
        int totalLeaves=leaveRequestService.getTotalLeaves();

        model.addAttribute("requests",requests);
        model.addAttribute("leavesPending",leavesPending);
        model.addAttribute("leavesApproved",leavesApproved);
        model.addAttribute("leavesRejected",leavesRejected);
        model.addAttribute("totalLeaves",totalLeaves);
        return "analyzeRequests";

    }
}
