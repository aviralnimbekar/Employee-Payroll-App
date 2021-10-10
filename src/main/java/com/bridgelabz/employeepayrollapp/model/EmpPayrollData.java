package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmpPayrollDTO;
import lombok.Data;

@Data
public class EmpPayrollData {

    private int empId;
    private String name;
    private int salary;

    public EmpPayrollData(int empId, EmpPayrollDTO empPayrollDTO) {
        this.empId = empId;
        this.name = empPayrollDTO.getName();
        this.salary = empPayrollDTO.getSalary();
    }
}
