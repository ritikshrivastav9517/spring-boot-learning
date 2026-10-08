package com.codeshuttle.week1.demo.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {

    private HttpStatus status;
    private String message;


}
