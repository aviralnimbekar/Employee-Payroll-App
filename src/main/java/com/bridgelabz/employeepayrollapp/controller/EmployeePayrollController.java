package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp-service")
public class EmployeePayrollController {

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAllEmployeeData() {
        EmployeePayrollData empData = new EmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeeDataById(@PathVariable int empId) {
        return new ResponseEntity<String>("Get call Succeed for id : " + empId,
                                            HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO) {
        return new ResponseEntity<String>("created Employee Payroll Data for : " +
                                            employeeDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<String> updateEmployeePayrollData(@PathVariable int empId, @RequestBody EmployeePayrollDTO employeeDTO) {
        return new ResponseEntity<String>("updated Employee Payroll Data for : " + employeeDTO,
                                            HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
        return new ResponseEntity<String>("deleted Employee Payroll Data for : " + empId,
                HttpStatus.OK);
    }
}
