package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp-service")
public class EmployeePayrollController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAllEmployeeData() {
        EmployeePayrollData empData = employeeService.getAllEmployeeData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable int empId) {
        EmployeePayrollData empData = employeeService.getEmployeeDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get call success", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData empData = employeeService.addEmployeePayrollData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int empId,
                                                                 @RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData empData = employeeService.updateEmployeePayrollData(empId, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int empId) {
        EmployeePayrollData empData = employeeService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Employee Payroll Data", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
