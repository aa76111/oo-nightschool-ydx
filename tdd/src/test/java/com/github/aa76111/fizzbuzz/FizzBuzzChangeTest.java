package com.github.aa76111.fizzbuzz;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzChangeTest {

    public static final FizzBuzzChange FIZZ_BUZZ_CHANGE = new FizzBuzzChange();
    private ArrayList<Pair<Integer, String>> mockDatas;

    @Before
    public void setUp() {
        mockDatas = new ArrayList<Pair<Integer, String>>() {{
            add(new Pair<>(1, "1"));
            add(new Pair<>(2, "2"));
            add(new Pair<>(3, "Fizz"));
            add(new Pair<>(5, "Buzz"));
            add(new Pair<>(10, "Buzz"));
            add(new Pair<>(15, "FizzBuzz"));
            add(new Pair<>(35, "FizzBuzz"));
            add(new Pair<>(53, "FizzBuzz"));
            add(new Pair<>(100, "Buzz"));
            add(new Pair<>(155, "Buzz"));
        }};
    }

    @Test
    public void should_say_correct_when_input() {
        mockDatas.forEach(pair -> assertThat(FIZZ_BUZZ_CHANGE.say(pair.getKey())).isEqualTo(pair.getValue()));
    }


}
