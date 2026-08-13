package com.example.calculator.controller;

import com.example.calculator.model.CalculationRequest;
import com.example.calculator.model.CalculationResponse;
import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @Test
    void shouldAddNumbers() {

        CalculationRequest request = new CalculationRequest();
        request.setA(20);
        request.setB(5);

        when(calculatorService.add(20, 5)).thenReturn(25.0);
        ResponseEntity<CalculationResponse> response = calculatorController.add(request);

        assertEquals(20.0, response.getBody().getResult());
        verify(calculatorService).add(20, 5);
    }

    @Test
    void shouldSubtractNumbers() {

        CalculationRequest request = new CalculationRequest();
        request.setA(10);
        request.setB(5);

        when(calculatorService.subtract(10, 5)).thenReturn(5.0);
        ResponseEntity<CalculationResponse> response = calculatorController.subtract(request);

        assertEquals(5.0, response.getBody().getResult());
        verify(calculatorService).subtract(10, 5);
    }

    @Test
    void shouldMultiplyNumbers() {

        CalculationRequest request = new CalculationRequest();
        request.setA(10);
        request.setB(5);

        when(calculatorService.multiply(10, 5)).thenReturn(50.0);
        ResponseEntity<CalculationResponse> response = calculatorController.multiply(request);

        assertEquals(50.0, response.getBody().getResult());
        verify(calculatorService).multiply(10, 5);
    }

    @Test
    void shouldDivideNumbers() {

        CalculationRequest request = new CalculationRequest();
        request.setA(10);
        request.setB(5);

        when(calculatorService.divide(10, 5)).thenReturn(2.0);

        ResponseEntity<CalculationResponse> response = calculatorController.divide(request);

        assertEquals(2.0, response.getBody().getResult());
        verify(calculatorService).divide(10, 5);
    }
}