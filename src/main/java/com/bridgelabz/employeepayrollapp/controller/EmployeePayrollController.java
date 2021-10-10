package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmpPayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmpPayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-service")
public class EmployeePayrollController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAllEmployeeData() {
        List<EmpPayrollData> empData = employeeService.getAllEmployeeData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable int empId) {
        EmpPayrollData empData = employeeService.getEmployeeDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get call success", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmpPayrollDTO employeeDTO) {
        EmpPayrollData empData = employeeService.addEmployeePayrollData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int empId,
                                                                 @RequestBody EmpPayrollDTO employeeDTO) {
        EmpPayrollData empData = employeeService.updateEmployeePayrollData(empId, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int empId) {
        EmpPayrollData empData = employeeService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Employee Payroll Data for id : " + empId,
                                                    empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
