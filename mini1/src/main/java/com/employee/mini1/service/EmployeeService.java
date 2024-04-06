package com.employee.mini1.service;

import com.employee.mini1.dto.employeedto;

import java.util.List;

public interface EmployeeService {
    employeedto createemployee(employeedto Employeedto);
    employeedto getemployeeById(Long EmployeeId);
     List<employeedto> getAllemployees();
     employeedto updateemployee(Long EmployeeId, employeedto updatedemployee);
void deleteemployee(Long EmployeeId);
    employeedto viewemployee(Long EmployeeId);

}
