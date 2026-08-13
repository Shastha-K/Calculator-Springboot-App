package com.example.calculator.service;

import com.example.calculator.Exception.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void shouldAddTwoNumbers() {
        double result = calculatorService.add(10, 5);
        assertEquals(15, result);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        double result = calculatorService.subtract(10, 5);
        assertEquals(5, result);
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        double result = calculatorService.multiply(10, 5);
        assertEquals(50, result);
    }

    @Test
    void shouldDivideTwoNumbers() {
        double result = calculatorService.divide(10, 5);
        assertEquals(2, result);
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        assertThrows(CalculatorException.class, () -> calculatorService.divide(10, 0));
    }
}