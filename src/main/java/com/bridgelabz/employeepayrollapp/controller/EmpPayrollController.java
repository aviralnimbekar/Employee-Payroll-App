package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmpPayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.model.EmpPayrollData;
import com.bridgelabz.employeepayrollapp.service.EmpPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Receive various HTTP request from clint
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 10/10/2021
 */
@RestController
@RequestMapping("/emp-service")
public class EmpPayrollController {

    @Autowired
    private EmpPayrollService empPayrollService;

    /**
     * Function to receive get request from clint
     *
     * @return list of all employee payroll data
     */
    @GetMapping({"", "/", "/get"})
    public ResponseEntity<ResponseDto> getAllEmpData() {
        List<EmpPayrollData> empData = empPayrollService.getAllEmpData();
        ResponseDto responseDto = new ResponseDto("Get call success", empData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to receive get request from clint
     *
     * @param empId unique Id of employee
     * @return response entity employee payroll data from DB
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmpDataById(@PathVariable int empId) {
        EmpPayrollData empData = empPayrollService.getEmpDataById(empId);
        ResponseDto responseDto = new ResponseDto("Get call success", empData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to receive post request from clint
     *
     * @param EmpDto employee payroll data from clint
     * @return response entity newly created employee payroll data
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmpPayrollData(@RequestBody EmpPayrollDto EmpDto) {
        EmpPayrollData empData = empPayrollService.addEmpPayrollData(EmpDto);
        ResponseDto responseDto = new ResponseDto("Created Employee Payroll Data", empData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to receive put request from clint
     *
     * @param empId  unique Id of employee
     * @param EmpDto employee payroll data from clint
     * @return response entity updated employee payroll data
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmpPayrollData(@PathVariable int empId,
                                                            @RequestBody EmpPayrollDto EmpDto) {
        EmpPayrollData empData = empPayrollService.updateEmpPayrollData(empId, EmpDto);
        ResponseDto responseDto = new ResponseDto("Updated Employee Payroll Data", empData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to receive delete request from clint
     *
     * @param empId unique Id of employee
     * @return response entity with conformation message
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmpPayrollData(@PathVariable int empId) {
        EmpPayrollData empData = empPayrollService.deleteEmpPayrollData(empId);
        ResponseDto responseDto = new ResponseDto("Deleted Employee Payroll Data for id : " + empId,
                empData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
