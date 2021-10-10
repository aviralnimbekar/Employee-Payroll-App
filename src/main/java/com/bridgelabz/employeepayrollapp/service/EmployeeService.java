package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmpPayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmpPayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<EmpPayrollData> empDataList = new ArrayList<>();

    public List<EmpPayrollData> getAllEmployeeData() {
        return empDataList;
    }

    public EmpPayrollData getEmployeeDataById(int empId) {
        return empDataList.get(empId - 1);
    }

    public EmpPayrollData addEmployeePayrollData(EmpPayrollDTO empPayrollDTO) {
        EmpPayrollData empData = new EmpPayrollData(1, empPayrollDTO);
        empDataList.add(empData);
        return empData;
    }

    public EmpPayrollData updateEmployeePayrollData(int empId, EmpPayrollDTO empPayrollDTO) {
        EmpPayrollData empData = this.getEmployeeDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        EmpPayrollData newEmpData = empData;
        return newEmpData;
    }

    public EmpPayrollData deleteEmployeePayrollData(int empId) {
        empDataList.remove(empId - 1);
        return null;
    }
}
