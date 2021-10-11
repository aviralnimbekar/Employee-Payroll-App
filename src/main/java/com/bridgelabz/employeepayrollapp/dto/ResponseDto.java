package com.bridgelabz.employeepayrollapp.dto;

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
public class ResponseDto {

    private String message;
    private Object data;

    public ResponseDto(String message, Object empData) {
        this.message = message;
        data = empData;
    }
}
