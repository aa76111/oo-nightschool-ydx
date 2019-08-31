package com.github.aa76111.fizzbuzz;

public class FizzBuzz {

    public String say(int number) {
        String result = "";
        if (number % 3 == 0) {
            result += "Fizz";
        }
        if (number % 5 == 0) {
            result += "Buzz";
        }
        return "".equals(result) ? String.valueOf(number) : result;
    }
}
