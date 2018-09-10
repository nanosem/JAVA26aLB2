package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
        Розробити та продемонструвати програму мовою Java в середовищі Eclipse для вирішення прикладної задачі за номером,
        що відповідає збільшеному на одиницю залишку від ділення на 10 зменшеного на одиницю номера студента в журналі групи.
        */

        int studentNumber = 24;
        int result = ((studentNumber - 1) % 10) + 1;
        System.out.println(result);

        // Знайти найбільший спільний дільник двох цілих позитивних чисел.
        for (int i = 0; i < 10; i++) {
            int first = getPositiveNumber();
            int second = getPositiveNumber();
            int gcd = gcd(first, second);
        }

        // Знайти суму цифр заданого цілого числа.
        int number = getPositiveNumber();
        int sumOfDigits = numberDigitsSum(number);
        System.out.println("Sum of digits of number " + number + " is " + sumOfDigits);

        // Знайти найбільшу цифру в десятковому запису цілочисельного значення.
        int randomNumber = getPositiveNumber();
        System.out.println("The biggest digit of number " + randomNumber + " is " + biggestDigitOfNumber(randomNumber));

        // Знайти позиції всіх найменших цифр в десятковому запису цілочисельного значення.
        int smallestDigit = smallestDigitOfNumber(randomNumber);
        printPositionOf(smallestDigit, randomNumber);
    }

    // Function that returns random positive number.
    private static int getPositiveNumber() {
        Random rand = new Random();
        return Math.abs(rand.nextInt());
    }

    // Function that returns the greatest common divisor.
    private static int gcd(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int temp = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        return firstNumber;
    }

    // Function that returns sum of number's digit.
    private static int numberDigitsSum(int number) {
        int sum = 0;
        do {
            int currentDigit = number % 10;
            number /= 10;
            sum += currentDigit;

        } while (number > 0);
        return sum;
    }

    // Returns the smallest digit of given number.
    private static int smallestDigitOfNumber(int number) {
        int smallestDigit = number % 10;
        do {
            number /= 10;
            int currentDigit = number % 10;
            if (currentDigit < smallestDigit) {
                smallestDigit = currentDigit;
            }
        } while (number > 9);
        return smallestDigit;
    }

    // Returns the biggest digit of given number.
    private static int biggestDigitOfNumber(int number) {
        int digit = number % 10;
        do {
            number /= 10;
            int currentDigit = number % 10;
            if (currentDigit > digit) {
                digit = currentDigit;
            }
        } while (number > 9);
        return digit;
    }

    private static void printPositionOf(int digit, int number) {
        number = reverseNumber(number);
        int currentDigit = number % 10;
        int currentIndex = 0;
        do {
            number /= 10;
            if (currentDigit == digit) {
                System.out.println(currentIndex);
            }
            currentDigit = number % 10;
            currentIndex++;
        } while(number > 9);
    }

    private static int reverseNumber(int number) {
        int reversed = number % 10;
        int decimal = 10;
        do {
            number /= 10;
            reversed *= 10;
            reversed += (number % 10);
        } while(number > 9);
        return reversed;
    }
}