package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

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

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @NotNull(message = "Date can not be empty, put date in DD-MMM-YYYY format")
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "This is Future date!!!")
    public LocalDate startDate;

    @NotNull(message = "Department should not be empty")
    public List<String> departments;

    @Min(value = 500, message = "Salary must be more than 500")
    public int salary;

    @NotBlank(message = "Select a Profile picture")
    public String profilePic;

    @NotBlank(message = "Note cannot be empty")
    public String note;
}
