package com.bridgelabz.employeepayrollapp.exceptions;

import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmpPayrollExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<ObjectError> errList = e.getBindingResult().getAllErrors();
        List<String> errMsg = errList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto responseDto =
                new ResponseDto("Exception while processing REST Request", errMsg);
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmpPayrollException.class)
    public ResponseEntity<ResponseDto> handleEmpPayrollException(
            EmpPayrollException e) {
        ResponseDto responseDto =
                new ResponseDto("Exception while processing REST Request", e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }
}
