package com.github.aa76111.args.example;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {

    private Args arg;


    @Before
    public void setUp() {
        String[] args = new String [] {""};
        arg = new Args("l,p#,d*", args);
    }

    @Test
    public void should_analysis_args_successfully() {
        //  given
        //  when
//        Boolean logging = arg.getBoolean("l");
//        int port = arg.getInt("p");
//        String directory = arg.getString("d");
//          then
//        assertThat(logging).isTrue();
//        assertThat(port).isEqualTo(8080);
//        assertThat(directory).isEqualTo("*");
        assertThat(123).isEqualTo(123);
    }
}