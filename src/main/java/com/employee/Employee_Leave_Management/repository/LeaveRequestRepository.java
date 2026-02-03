package com.employee.Employee_Leave_Management.repository;

import com.employee.Employee_Leave_Management.entity.Employee;
import com.employee.Employee_Leave_Management.entity.LeaveRequest;
import com.employee.Employee_Leave_Management.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {
    List<LeaveRequest> findByEmployee(Employee employee);

    List<LeaveRequest> findByStatus(Status status);
}
