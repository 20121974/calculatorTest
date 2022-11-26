package com.skypro.calculator.controller;

import com.skypro.calculator.exception.IllegalNumberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServis calculatorServis;

    public CalculatorController(CalculatorServis calculatorServis) {
        this.calculatorServis = calculatorServis;
    }

    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberHandler(IllegalNumberException) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @GetMapping("/")
    public String hello() {
        return "Hello, Username!";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1,@RequestParam("num2") int num2) {
        int result = calculatorServis.plus(num1,num2);
        return String.format(%d + %d = %d, num1,num2,result);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1,@RequestParam("num2") int num2) {
        int result = calculatorServis.minus(num1,num2);
        return String.format(%d - %d = %d, num1,num2,result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1,@RequestParam("num2") int num2) {
        int result = calculatorServis.multiply(num1,num2);
        return String.format(%d * %d = %d, num1,num2,result);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1,@RequestParam("num2") int num2) {
        int result = calculatorServis.divide(num1,num2);
        return String.format(%d - %d = %d, num1,num2,result);
    }
}
