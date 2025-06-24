package com.aidiph.api.aidiph_payroll_service.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String error;
    private String message;
    private Integer code;
}
