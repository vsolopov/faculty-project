package com.hneu.api.controller.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {
    private static final String PATH = "/exception";

    @RequestMapping(value = PATH)
    private String error() {
        return "Page not found :c";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
