package com.employee.Employee_Leave_Management.service;

import com.employee.Employee_Leave_Management.entity.Employee;
import com.employee.Employee_Leave_Management.repository.EmployeeRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public EmployeeRepository employeeRepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    public AdminService(EmployeeRepository employeeRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void registerUser(Employee employee) {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }
}
