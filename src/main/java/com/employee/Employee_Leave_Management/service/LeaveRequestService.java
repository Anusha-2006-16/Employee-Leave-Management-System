package com.employee.Employee_Leave_Management.service;

import com.employee.Employee_Leave_Management.entity.Employee;
import com.employee.Employee_Leave_Management.entity.LeaveRequest;
import com.employee.Employee_Leave_Management.entity.Status;
import com.employee.Employee_Leave_Management.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public void applyRequest(LeaveRequest leaveRequest, Employee employee) {
        if(leaveRequest.getStatus() == null){
            leaveRequest.setStatus(Status.PENDING);
        }
        leaveRequest.setAppliedAt(LocalDateTime.now());
        leaveRequest.setEmployee(employee);
        leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> findByEmployee(Employee employee) {
  return leaveRequestRepository.findByEmployee(employee);
    }

    public List<LeaveRequest> getAllRequests() {
        return leaveRequestRepository.findAll();
    }

    public void updateEmployeeApproval(Long id,Status status,String comment) {
       LeaveRequest leaveRequest = getById(id);
       leaveRequest.setStatus(status);
       leaveRequest.setManagerComment(comment);
       leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest getById(Long id) {
        return leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

    }
List<LeaveRequest> leaveRequests;
    public int getLeavesPending() {
        int cnt=0;
        leaveRequests=leaveRequestRepository.findAll();
        for(LeaveRequest leaveRequest:leaveRequests){
            if(leaveRequest.getStatus()==Status.PENDING){
             cnt++;
            }
        }
        return cnt;
    }

    public int getLeavesApproved() {
        int cnt=0;
        leaveRequests=leaveRequestRepository.findAll();
        for(LeaveRequest leaveRequest:leaveRequests){
            if(leaveRequest.getStatus()==Status.APPROVED){
                cnt++;
            }
        }
        return cnt;
    }

    public int getLeavesRejected() {
        int cnt=0;
        leaveRequests=leaveRequestRepository.findAll();
        for(LeaveRequest leaveRequest:leaveRequests){
            if(leaveRequest.getStatus()==Status.REJECTED){
                cnt++;
            }
        }
        return cnt;
    }

    public int getTotalLeaves() {
        int cnt=0;
        leaveRequests=leaveRequestRepository.findAll();
        return leaveRequests.size();
    }

    public List<LeaveRequest> getRequestsByStatus(Status status) {
        return leaveRequestRepository.findByStatus(status);
    }
}
