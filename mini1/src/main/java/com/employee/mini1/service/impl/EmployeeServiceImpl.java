package com.employee.mini1.service.impl;

import com.employee.mini1.Mapper.employeemap;
import com.employee.mini1.dto.employeedto;
import com.employee.mini1.entity.employee;
import com.employee.mini1.execption.ResourceNotFoundException;
import com.employee.mini1.repo.employeerepo;
import com.employee.mini1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final employeerepo Employeerepo;

    @Autowired
    public EmployeeServiceImpl(employeerepo Employeerepo) {
        this.Employeerepo = Employeerepo;
    }

    @Override
    public employeedto createemployee(employeedto Employeedto) {
        employee Employee = employeemap.mapToemployee(Employeedto);
        employee savedemployee = Employeerepo.save(Employee);
        return employeemap.mapToemployeedto(savedemployee);
    }

    @Override
    public employeedto getemployeeById(Long EmployeeId) {
       employee Employee = Employeerepo.findById(EmployeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id:"+EmployeeId));
        return employeemap.mapToemployeedto(Employee);
    }

    @Override
    public List<employeedto> getAllemployees() {
        List<employee> Employees = Employeerepo.findAll();

        return Employees.stream().map((Employee)->employeemap.mapToemployeedto(Employee))
                .collect(Collectors.toList());
    }

    @Override
    public employeedto updateemployee(Long EmployeeId, employeedto updatedemployee) {
        employee Employee =  Employeerepo.findById(EmployeeId).orElseThrow(()-> new ResourceNotFoundException("employee is not exist with given id:"+EmployeeId));

       Employee.setFirstName(updatedemployee.getFirstName());
        Employee. setLastName(updatedemployee.getLastName());
        Employee.setEmail(updatedemployee.getEmail());
     employee updatedEmployeeObj =   Employeerepo.save(Employee);
        return employeemap.mapToemployeedto(updatedEmployeeObj);
    }

    @Override
    public void deleteemployee(Long EmployeeId) {
        employee Employee =  Employeerepo.findById(EmployeeId).orElseThrow(()-> new ResourceNotFoundException("employee is not exist with given id:"+EmployeeId));
        Employeerepo.deleteById(EmployeeId);

      }

    @Override
    public employeedto viewemployee(Long EmployeeId) {
        employee Employee = Employeerepo.findById(EmployeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id:" + EmployeeId));
        return employeemap.mapToemployeedto(Employee);

    }

}

