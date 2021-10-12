package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmpPayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Create and maintains employee payroll data in object.
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 10/10/2021
 */
@Data
@NoArgsConstructor
public class EmpPayrollData {

    private int empId;
    private String name;
    private String gender;
    private List<String> departments;
    private LocalDate startDate;
    private int salary;
    private String profilePic;
    private String note;
}
