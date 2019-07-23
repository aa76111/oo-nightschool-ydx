package com.github.aa76111;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChanceTest {
    private Chance chanceA;
    private Chance chanceB;

    @Before
    public void setUp() throws Exception {
        chanceA = new Chance(0.46D);
        chanceB = new Chance(0.78D);
    }

    @Test
    public void should_get_and_chance() {
        //  given

        //  when

        //  then
        assertThat(chanceA.and(chanceB)).isEqualToComparingFieldByField(new Chance(0.3588D));
    }

    @Test
    public void should_get_not_chance() {
        //  given

        //  when

        //  then
        assertThat(chanceA.not()).isEqualToComparingFieldByField(new Chance(0.54D));
    }

    @Test
    public void should_get_or_chance() {
        //  given

        //  when

        //  then
        assertThat(chanceA.or(chanceB)).isEqualToComparingFieldByField(new Chance(0.8812D));
    }

    @Test
    public void should_get_xor_chance() {
        //  given

        //  when

        //  then
        assertThat(chanceA.xor(chanceB)).isEqualToComparingFieldByField(new Chance(0.5224D));
    }
}