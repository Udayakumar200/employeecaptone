package com.employee.mini1.repo;

import com.employee.mini1.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface employeerepo extends JpaRepository<employee,Long> {

}
