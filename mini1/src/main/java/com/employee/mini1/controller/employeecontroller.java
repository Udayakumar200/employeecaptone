package com.employee.mini1.controller;

import com.employee.mini1.dto.employeedto;
import com.employee.mini1.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class employeecontroller {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<employeedto> createemployee(@RequestBody employeedto Employeedto) {
        employeedto savedemployee = employeeService.createemployee(Employeedto);
        return new ResponseEntity<>(savedemployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<employeedto> getemployeeById(@PathVariable("id") Long EmployeeId) {
        employeedto Employeedto = employeeService.getemployeeById(EmployeeId);
        return ResponseEntity.ok(Employeedto);
    }

    @GetMapping
    public ResponseEntity<List<employeedto>> getAllemployees() {
        List<employeedto> Employees = employeeService.getAllemployees();
        return ResponseEntity.ok(Employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<employeedto> updateemployee(@PathVariable("id") Long EmployeeId, @RequestBody employeedto updatedemployee) {
        employeedto Employeedto = employeeService.updateemployee(EmployeeId, updatedemployee);
        return ResponseEntity.ok(Employeedto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteemployee(@PathVariable("id") Long EmployeeId) {
        employeeService.deleteemployee(EmployeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!");
    }



    @GetMapping("/{id}/view")
    public ResponseEntity<employeedto> viewemployee(@PathVariable("id") Long EmployeeId) {
        employeedto employeeDto = employeeService.viewemployee(EmployeeId);
        return ResponseEntity.ok(employeeDto);
    }


}
