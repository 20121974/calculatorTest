package com.skypro.calculator;

import com.skypro.calculator.exception.IllegalNumberException;
import com.skypro.calculator.servis.CalculatorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void twoPlusTwo() {
        int result = calculatorService.plus(2, 2);
        Assertions.assertEquals(4, result);
    }
    @ParameterizedTest
    @MethodSource("plusTestSuites")
    public void plusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }

    @MethodSource("multiplyTestSuites")
    public void plusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }
    @MethodSource("divideTestSuites")
    public void plusTest(int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }

    @Test
    public void divideByZeroTrowsException() {
        Assertions.assertThatThrownBy(IllegalNumberException.class,() ->{calculatorService.divide(1,0)};
    }
    public static List<Arguments> plusTestSuites() {
        return List.of(
                Arguments.of(10, 5, 15),
                Arguments.of(-5, 3, -2));

    }
}
