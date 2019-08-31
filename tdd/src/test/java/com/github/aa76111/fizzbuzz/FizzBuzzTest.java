package com.github.aa76111.fizzbuzz;

import com.github.aa76111.fizzbuzz.FizzBuzz;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private ArrayList<Pair<Integer, String>> dataMocks;
    public static final FizzBuzz fizzBuzz = new FizzBuzz();

    @Before
    public void setUp() {
        dataMocks = new ArrayList<Pair<Integer, String>>() {{
            add(new Pair<>(1, "1"));
            add(new Pair<>(3, "Fizz"));
            add(new Pair<>(5, "Buzz"));
            add(new Pair<>(15, "FizzBuzz"));
        }};
    }

    @Test
    public void should_say_correct_when_input_number() {
        //  given
        //  when

        //  then
        dataMocks.forEach(pair -> assertThat(fizzBuzz.say(pair.getKey())).isEqualTo(pair.getValue()));
    }

}