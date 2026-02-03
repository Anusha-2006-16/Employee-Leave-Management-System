package com.employee.Employee_Leave_Management.service;

import com.employee.Employee_Leave_Management.entity.Employee;
import com.employee.Employee_Leave_Management.entity.LeaveRequest;
import com.employee.Employee_Leave_Management.entity.Status;
import com.employee.Employee_Leave_Management.repository.EmployeeRepository;
import com.employee.Employee_Leave_Management.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final LeaveRequestRepository leaveRequestRepository;
    public EmployeeService(EmployeeRepository employeeRepository, LeaveRequestRepository leaveRequestRepository) {
        this.employeeRepository = employeeRepository;
        this.leaveRequestRepository = leaveRequestRepository;
    }
    public void applyRequest(LeaveRequest leaveRequest) {
        if(leaveRequest.getStatus()==null){
            leaveRequest.setStatus(Status.valueOf("PENDING"));
        }
        leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> findByEmployee(Employee employee) {
        return leaveRequestRepository.findByEmployee(employee);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee getById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

    public void updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setRole(employee.getRole());

        employeeRepository.save(existingEmployee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

    public void save(Employee emp) {
        employeeRepository.save(emp);
    }
}
