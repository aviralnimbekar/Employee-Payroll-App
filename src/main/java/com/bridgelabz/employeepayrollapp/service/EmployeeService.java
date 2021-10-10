package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollData;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeePayrollData getAllEmployeeData() {
        return new EmployeePayrollData();
    }

    public EmployeePayrollData getEmployeeDataById(int empId) {
        return null;
    }

    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeeDTO) {
        return new EmployeePayrollData(1, employeeDTO);
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeeDTO) {
        return new EmployeePayrollData(empId, employeeDTO);
    }

    public EmployeePayrollData deleteEmployeePayrollData(int empId) {
        return null;
    }
}
