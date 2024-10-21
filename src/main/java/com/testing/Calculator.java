package com.testing;

import java.util.Set;
import java.util.stream.Collectors;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public Set<Integer> getDigits(int number) {
        return String.valueOf(Math.abs(number)).chars().map(Character::getNumericValue).boxed()
                .collect(Collectors.toSet());
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}
