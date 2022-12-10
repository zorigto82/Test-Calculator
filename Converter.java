package Exercises.Calculator;

public class Converter {

    int[] arabNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
            13, 14, 15, 16, 17, 18, 19, 20, 21, 24, 25, 27, 28, 30,
            32, 35, 36, 40, 42, 45, 48, 49, 50, 54, 56, 60, 63, 64,
            70, 72, 80, 81, 90, 100};

    String[] romans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
            "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXIV", "XXV", "XXVII", "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL",
            "XLII", "XLV", "XLVIII", "XLIX", "L", "LIV", "LVI", "LX",
            "LXIII", "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};

    boolean isRomNum(String input) {
        boolean marker = false;
        for (String roman : romans) {
            if (input.equals(roman)) {
                marker = true;
                break;
            }
        }
        return marker;
    }

    String toInt(String input) {
        return switch (input) {
            case "I" -> String.valueOf(1);
            case "II" -> String.valueOf(2);
            case "III" -> String.valueOf(3);
            case "IV" -> String.valueOf(4);
            case "V" -> String.valueOf(5);
            case "VI" -> String.valueOf(6);
            case "VII" -> String.valueOf(7);
            case "VIII" -> String.valueOf(8);
            case "IX" -> String.valueOf(9);
            case "X" -> String.valueOf(10);
            default -> "Некорректное выражение. Введите римские от I до X включительно";
        };
    }

    String intToRoman(String result) {
        for (int i = 0; i < arabNumbers.length; i++) {
            if (result.equals(String.valueOf(arabNumbers[i]))) {
                return romans[i];
            }
        }
        return "";
    }

}
