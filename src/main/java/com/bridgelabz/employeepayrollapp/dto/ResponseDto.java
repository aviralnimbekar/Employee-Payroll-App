package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create and maintains response data in object.
 * class contains a message field and a general field for any type of data
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 10/10/2021
 */
@Data
@AllArgsConstructor
public class ResponseDto {

    private String message;
    private Object data;
}
