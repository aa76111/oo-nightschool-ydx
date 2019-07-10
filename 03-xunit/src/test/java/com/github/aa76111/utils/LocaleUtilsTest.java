package com.github.aa76111.utils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Locale;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LocaleUtilsTest {
    String EMPTY = null;
    LocaleUtils localeUtils = null;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        localeUtils = new LocaleUtils();
        EMPTY = "";
    }

    @Test
    public void should_return_null_when_str_isNull() {
        //  given
        String str = null;
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualTo(null);
    }

    @Test
    public void should_return_EmptyLocal_when_str_isEmpty() {
        //  given
        String str = "";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale(EMPTY, EMPTY));
    }
    @Test
    public void should_throw_EmptyLocal_when_str_isEmpty_null() {
        //  given
        String str = ""+null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_return_EmptyLocal_when_str_isLength0() {
        //  given
        String str = "";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale(EMPTY, EMPTY));
    }

    @Test
    public void should_throw_IllegalArgumentException_when_str_containsSharp() {
        //  given
        String str = "12312312#";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_str_length_st2() {
        //  given
        String str = "1";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_str_containsUnderline_And_lengthSt3() {
        //  given
        String str = "_1";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_str_containsUnderline_And_ch1_lower() {
        //  given
        String str = "_aB";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_str_containsUnderline_And_ch1andch2NotallUpperCase() {
        //  given
        String str = "_Ab";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_return_1and3Local_when_str_isEmpty() {
        //  given
        String str = "_AB";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale(EMPTY, str.substring(1, 3)));
    }

    @Test
    public void should_throw_IllegalArgumentException_when_str_length5() {
        //  given
        String str = "_ABC";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_str_charAt3_is_not_underline() {
        //  given
        String str = "_ABCDEF";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_return_splice_when_str_isStartwith_underline() {
        //  given
        String str = "_AB_SADSAD";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale(EMPTY, str.substring(1, 3), str.substring(4)));
    }

    @Test
    public void should_return_when_str_not_startwith_underline_and_isISO639LanguageCode_length_2() {
        //  given
        String str = "ba";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale(str));
    }
    @Test
    public void should_return_when_str_not_startwith_underline_and_isISO639LanguageCode_length_3() {
        //  given
        String str = "baa";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale(str));
    }

    @Test
    public void should_return_when_str_not_startwith_underline_and_allUpperCase_and_alltrue() {
        //  given
        String str = "ch_CD";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale("ch", "CD"));
    }
    @Test
    public void should_return_when_str_not_startwith_underline_and_allUpperCase_and_alltrue_not_country_areacode() {
        //  given
        String str = "ch_123";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale("ch", "123"));
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_allUpperCase_and_false() {
        //  given
        String str = "ch_12a";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_return_when_str_not_startwith_underline_and_split2_and_all_true() {
        //  given
        String str = "ch_123";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale("ch", "123"));
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_isISO639LanguageCode_false() {
        //  given
        String str = "ch_1234";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_when_str_not_startwith_underline_and_isISO639LanguageCode_false_not_all() {
        //  given
        String str = "chdasdaAdasdsa";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_when_str_not_startwith_underline_and_split2_false() {
        //  given
        String str = "ch_ABC";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_throw_when_str_not_startwith_underline_and_split2_false_1() {
        //  given
        String str = "chab_ABC";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_isalluppercase_false() {
        //  given
        String str = "chab_";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_isalluppercase_false_2_null() {
        //  given
        String str = "cb_";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_isalluppercase_false_2_empty() {
        //  given
        String str = "cb_ "+ null;
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);

        //  when

        //  then
        localeUtils.toLocale(str);
    }

    @Test
    public void should_return_when_str_not_startwith_underline_and_split3_and_all_true_country_length0() {
        //  given
        String str = "ch__123";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale("ch", "","123"));
    }

    @Test
    public void should_return_when_str_not_startwith_underline_and_split3_and_all_true_country_isISO3166CountryCode() {
        //  given
        String str = "ch_AB_123";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale("ch", "AB","123"));
    }

    @Test
    public void should_return_when_str_not_startwith_underline_and_split3_and_all_true_country_isNumericAreaCode() {
        //  given
        String str = "ch_123_123";
        //  when

        //  then
        assertThat(localeUtils.toLocale(str)).isEqualToComparingFieldByField(new Locale("ch", "123","123"));
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_split3_and_not_isISO639LanguageCode() {
        //  given
        String str = "chB_123_";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_split3_and_variant_length_ls_0() {
        //  given
        String str = "ch_123_";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }
    @Test
    public void should_throw_when_str_not_startwith_underline_and_split3_and_country_false() {
        //  given
        String str = "ch_1234_";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid locale format: "+str);
        //  when

        //  then
        localeUtils.toLocale(str);
    }
}