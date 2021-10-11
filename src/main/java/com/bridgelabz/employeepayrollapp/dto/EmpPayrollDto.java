package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Receive data object from clint
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 10/10/2021
 */
@Data
public class EmpPayrollDto {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Salary must be more than 500")
    public int salary;
}
