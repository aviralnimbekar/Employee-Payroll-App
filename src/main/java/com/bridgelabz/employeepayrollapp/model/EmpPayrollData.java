package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmpPayrollDto;
import lombok.Data;

/**
 * Create and maintains employee payroll data in object.
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 10/10/2021
 */
@Data
public class EmpPayrollData {

    private int empId;
    private String name;
    private int salary;

    public EmpPayrollData(int empId, EmpPayrollDto empPayrollDTO) {
        this.empId = empId;
        this.name = empPayrollDTO.getName();
        this.salary = empPayrollDTO.getSalary();
    }
}
