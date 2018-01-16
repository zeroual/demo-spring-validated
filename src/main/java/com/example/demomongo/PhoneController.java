package com.example.demomongo;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated()
public class PhoneController {

    private static final String VALIDATION_REGEX = "^0[1-9]([0-9]{2}){4}$";

    @GetMapping("/check/{number}")
    public String checkPhoneNumber(@PathVariable("number")
                                   @Valid @Pattern(regexp = VALIDATION_REGEX) String number) {
        return number;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(ConstraintViolationException exception) {
    }
}
