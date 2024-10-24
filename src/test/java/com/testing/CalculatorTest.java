package com.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    private Calculator calculator;

    private static Instant startedAt;

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Appel avant tout les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("Appel après tout les tests");
        final Instant endedAt = Instant.now();
        final long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des test : {0} ms", duration));

    }

    @BeforeEach
    public void initCalculator() {
        calculator = new Calculator();

    }

    @AfterEach
    public void undefCalculator() {
        calculator = null;
    }

    @Test
    void testAddTwoPositiveNumbers() {
        //Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculator.add(a, b);
        //Assert
        assertThat(somme).isEqualTo(5);
    }

    @Test
    void testMultiplyTwoNumbers() {
        //Arrange
        int a = 2;
        int b = 1;

        //Act
        int result = calculator.multiply(a, b);

        //Assert
        assertEquals(2, result);
        assertThat(result).isEqualTo(2);

    }

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = {1, 2, 3, 444, 555})
    public void testMultiplyZeroByIntegers(int arg) {
        // Arrange -- tout est prêt

        //Act -- Multiplier par zéro
        int result = calculator.multiply(arg, 0);

        //Assert -- ça vat toujours zéro
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
    @CsvSource({"1,2,3", "10,55,65", "5555,200,5755"})
    public void testAddOfMultipleIntegers(int arg1, int arg2, int expectedResult) {
        //Arrange -- tout est prêt

        //Act
        int result = calculator.add(arg1, arg2);
        //Assert
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void listDigits_shouldReturnListOfDigits_ofPositiveInteger() {
        //Arrange
        int number = 54321;
        //act
        Set<Integer> result = calculator.getDigits(number);
        //Assert
        assertThat(result).containsExactlyInAnyOrder(5, 4, 3, 2, 1);
    }

    @Test
    public void listDigits_shouldReturnListOfDigits_ofNegativeInteger() {
        //Arrange
        int number = -54321;
        //act
        Set<Integer> result = calculator.getDigits(number);
        //Assert
        assertThat(result).containsExactlyInAnyOrder(5, 4, 3, 2, 1);
    }

    @Test
    public void listDigits_shouldReturnZero_ofZero() {
        //Arrange
        int number = 0;
        //act
        Set<Integer> result = calculator.getDigits(number);
        //Assert
        assertThat(result).containsExactlyInAnyOrder(0);
    }
}
