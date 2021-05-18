package com.ds;


import java.time.Duration;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(1).plusHours(20).plusMinutes(20).plusSeconds(50);
        Duration duration = Duration.ofHours(200).plusMinutes(555);
        System.out.println(duration.toDays());

    }

    static double evaluate(String s) {
        boolean containsOperator = s.contains("/") || s.contains("*") || s.contains("+") || s.contains("-");
        if (containsOperator) {

            char operator = s.contains("/") ? '/' : s.contains("*") ? '*' : s.contains("+") ? '+' : '-';
            int operatorIndex = s.indexOf(operator);

            int startIndex = indexExtractor(operatorIndex, s, '-');
            int endIndex = indexExtractor(operatorIndex, s, '+');
            String syllable;

            if (endIndex + 1 == s.length()) {
                syllable = s.substring(startIndex);
            } else {
                syllable = s.substring(startIndex, endIndex + 1);
            }

            s = s.replace(syllable, String.valueOf(calculate(syllable, operator)));
            s = String.valueOf(evaluate(s));
        }
        return Double.parseDouble(s);
    }

    static int indexExtractor(int index, String s, char direction) {
        int tempIndex = index;

        char c;
        if (direction == '+') {
            index++;
            c = s.charAt(index);
            if (c == '.') {
                index++;
            }

        } else if (direction == '-') {
            index--;
            c = s.charAt(index);
            if (c == '.') {
                index--;
            }
        } else {
            throw new IllegalArgumentException();
        }

        try {
            double number = Double.parseDouble(String.valueOf(s.charAt(index)));
            if (index == 0 || index + 1 == s.length()) {
                return index;
            } else {
                index = indexExtractor(index, s, direction);
            }
        } catch (Exception ex) {
            return tempIndex;
        }
        return index;
    }


    static double calculate(String syllable, char operator) {
        int operatorIndex = syllable.indexOf(operator);
        double first = Double.parseDouble(syllable.substring(0, operatorIndex));
        double second = Double.parseDouble(syllable.substring(operatorIndex + 1));

        switch (operator) {
            case '/':
                return first / second;
            case '*':
                return first * second;
            case '+':
                return first + second;
            case '-':
                return first - second;
            default:
                return 0;
        }
    }
}
