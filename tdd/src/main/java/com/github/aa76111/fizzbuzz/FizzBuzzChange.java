package com.github.aa76111.fizzbuzz;

public class FizzBuzzChange {

    public String say(int number) {
        String result = "";
        if (isaBoolean(number, 3, "3")) {
            result += "Fizz";
        }
        if (isaBoolean(number, 5, "5")) {
            result += "Buzz";
        }
        if ("".equals(result)) {
            result = String.valueOf(number);
        }
        return result;
    }

    private boolean isaBoolean(int number, int i, String s) {
        return number % i == 0 || String.valueOf(number).contains(s);
    }
}
