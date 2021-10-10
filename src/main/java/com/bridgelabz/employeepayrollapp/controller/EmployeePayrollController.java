package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp-service")
public class EmployeePayrollController {

    @GetMapping({"", "/", "/get"})
    public ResponseEntity<String> getAllEmployeeData() {
        return new ResponseEntity<String>("Get call Succeed", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeeDataById(@PathVariable int empId) {
        return new ResponseEntity<String>("Get call Succeed for id : " + empId,
                                            HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<String>("created Employee Payroll Data for : " +
                                            employeeDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<String>("updated Employee Payroll Data for : " + employeeDTO,
                                            HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
        return new ResponseEntity<String>("deleted Employee Payroll Data for : " + empId,
                HttpStatus.OK);
    }
}
