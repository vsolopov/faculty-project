package com.hneu.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionView {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String exception;

}
