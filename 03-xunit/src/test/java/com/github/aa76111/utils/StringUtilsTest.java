package com.github.aa76111.utils;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringUtilsTest {
    CharSequence sequenceNull = null;
    CharSequence sequenceBlank = null;
    CharSequence sequenceZeroLength = null;
    CharSequence sequenceNoWhiteSpace = null;
    CharSequence sequenceAlpha = null;
    StringUtils stringUtils = null;
    String value = null;
    @Before
    public void setUp() throws Exception {
        sequenceNull = null;
        sequenceBlank = "  ";
        sequenceZeroLength = "";
        sequenceAlpha = "asdasd";
        sequenceNoWhiteSpace = "studyXunit";
        value = "aa76111";
        stringUtils = new StringUtils(value);
    }

    @Test
    public void should_return_true_if_isNull() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isEmpty(sequenceNull)).isTrue();
    }

    @Test
    public void should_return_true_if_zeroLength() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isEmpty(sequenceZeroLength)).isTrue();
    }

    @Test
    public void should_return_true_isBlank_if_isNull() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isBlank(sequenceNull)).isTrue();
    }

    @Test
    public void should_return_true_isBlank_if_zeroLength() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isBlank(sequenceZeroLength)).isTrue();
    }

    @Test
    public void should_return_true_isBlank() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isBlank(sequenceBlank)).isTrue();
    }

    @Test
    public void should_return_false_isBlank_noWhiteSpace() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isBlank(sequenceNoWhiteSpace)).isFalse();
    }

    @Test
    public void should_return_true_if_isAlpha() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isAlpha(sequenceAlpha)).isTrue();
    }

    @Test
    public void should_return_false_isAlpha_isEmpty() {
        //  given
        //  when

        //  then
        assertThat(stringUtils.isAlpha(sequenceNull)).isFalse();
    }

    @Test
    public void should_return_false_isAlpha_isNotAllLetter() {
        //  given
        CharSequence sequenceNotAllLetter = "ydx76111";

        //  when

        //  then
        assertThat(stringUtils.isAlpha(sequenceNotAllLetter)).isFalse();
    }

}