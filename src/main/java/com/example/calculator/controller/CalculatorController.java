package com.example.calculator.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.calculator.model.CalculationRequest;
import com.example.calculator.model.CalculationResponse;
import com.example.calculator.service.*;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    private ResponseEntity<CalculationResponse> createResponse(double result) {
        CalculationResponse response = new CalculationResponse(result);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(@RequestBody CalculationRequest request) {
        double result = calculatorService.add(request.getA(), request.getB());
        return createResponse(result);
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtract(@RequestBody CalculationRequest request) {
        double result = calculatorService.subtract(request.getA(), request.getB());
        return createResponse(result);
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiply(@RequestBody CalculationRequest request) {
        double result = calculatorService.multiply(request.getA(), request.getB());
        return createResponse(result);
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculationResponse> divide(@RequestBody CalculationRequest request) {
        double result = calculatorService.divide(request.getA(), request.getB());
        return createResponse(result);
    }

}
