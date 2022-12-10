package Exercises.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static final int length = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите выражение через пробел или end для выхода");
            String scan = scanner.nextLine();
            if (scan.equals("end")) {
                break;
            }
            System.out.println(calc(scan));
        }
    }

    public static String calc(String input) {
        Converter converter = new Converter();
        String[] parts = input.split(" ");
        String c = parts[1];
        if (parts.length != length)
            throw new ArrayIndexOutOfBoundsException("Формат математической операции не удовлетворяет" +
                    " заданию - два операнда и один оператор (+, -, /, *)");

        boolean x = converter.isRomNum(parts[0]);
        boolean y = converter.isRomNum(parts[2]);
        if (x != y) {
            throw new InputMismatchException("Используются одновременно разные системы счисления");
        }
        int a, b;
        if (x && y) {
            a = Integer.parseInt(converter.toInt(parts[0]));
            b = Integer.parseInt(converter.toInt(parts[2]));
        } else {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        }
        if (a > 10 || a < 0) {
            throw new IndexOutOfBoundsException("Выражение не соответствует заданному диапазону чисел" +
                    " от 0 до 10 включительно");
        }
        if (b > 10 || b < 0) {
            throw new IndexOutOfBoundsException("Выражение не соответствует заданному диапазону чисел" +
                    " от 0 до 10 включительно");
        }
        int result;
        switch (c) {
            case "+":
                if (x && y) {
                    result = a + b;
                    return converter.intToRoman(String.valueOf(result));
                } else {
                    return String.valueOf(a + b);
                }
            case "-":
                if (x && y) {
                    result = a - b;
                    if (a < b) {
                        throw new ArithmeticException("В римской системе нет отрицательных чисел");
                    }
                    return converter.intToRoman(String.valueOf(result));
                } else {
                    return String.valueOf(a - b);
                }
            case "/":
                if (x && y) {
                    result = a / b;
                    return converter.intToRoman(String.valueOf(result));
                } else {
                    return String.valueOf(a / b);
                }
            case "*":
                if (x && y) {
                    result = a * b;
                    return converter.intToRoman(String.valueOf(result));
                } else {
                    return String.valueOf(a * b);
                }
            default:
                return "Некорректный ввод";

        }

    }

}
