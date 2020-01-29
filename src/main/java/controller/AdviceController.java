package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author laste
 */
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "404";
    }   
}