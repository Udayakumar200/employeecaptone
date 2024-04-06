package com.employee.mini1.Mapper;

import com.employee.mini1.dto.employeedto;
import com.employee.mini1.entity.employee;


public class employeemap {
    public static employeedto mapToemployeedto(employee Employee){
        return new employeedto(
                Employee.getId(),
                Employee.getFirstName(),
                Employee.getLastName(),
                Employee.getEmail()
        );
    }
    public static employee mapToemployee(employeedto Employeedto){
        return new employee(
          Employeedto.getId(),
          Employeedto.getFirstName(),
          Employeedto.getLastName(),
          Employeedto.getEmail()
        );
    }
}
