package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmpPayrollDto;
import com.bridgelabz.employeepayrollapp.exceptions.EmpPayrollException;
import com.bridgelabz.employeepayrollapp.model.EmpPayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Layer contains business logic,
 * also implements all the method in controller layer
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 10/10/2021
 */
@Service
public class EmpPayrollService {

    List<EmpPayrollData> empDataList = new ArrayList<>();

    /**
     * Function to get the list of all employee stored in DB
     *
     * @return list of employee payroll data
     */
    public List<EmpPayrollData> getAllEmpData() {
        return empDataList;
    }

    /**
     * Function to get a particular employee data object stored in DB
     *
     * @param empId unique Id of employee
     * @return employee payroll data object
     */
    public EmpPayrollData getEmpDataById(int empId) {
        return empDataList.stream()
                .filter(empData -> empData.getEmpId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmpPayrollException("Employee ID Not Found"));
    }

    /**
     * Function to create employee payroll data object.
     * This function maps employee dto object into employee entity object and then store it into DB
     *
     * @param empPayrollDto employee payroll data from clint
     * @return employee payroll data created by this layer
     */
    public EmpPayrollData addEmpPayrollData(EmpPayrollDto empPayrollDto) {
        EmpPayrollData empData = new EmpPayrollData(1, empPayrollDto);
        empDataList.add(empData);
        return empData;
    }

    /**
     * Function to update stored employee payroll data object.
     * This function maps updated field of employee dto object into employee
     * entity object and then store updated object into DB
     *
     * @param empId         unique Id of employee
     * @param empPayrollDTO employee payroll data from clint
     * @return employee payroll data updated by this layer
     */
    public EmpPayrollData updateEmpPayrollData(int empId, EmpPayrollDto empPayrollDTO) {
        EmpPayrollData empData = this.getEmpDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        EmpPayrollData newEmpData = empData;
        return newEmpData;
    }

    /**
     * Function to get particular entity object from DB and remove/delete it.
     *
     * @param empId unique Id of employee
     * @return String message containing status of operation
     */
    public EmpPayrollData deleteEmpPayrollData(int empId) {
        empDataList.remove(empId - 1);
        return null;
    }
}
