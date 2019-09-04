package com.github.aa76111.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {

    @Test
    public void should_analysis_args_correct_successfully() {
        //  given
//        Args arg = new Args("l,p#,d*", new String[]{"-l","-p","8080","-d","user/local"});
//        //  when
//        Boolean logging = arg.getBoolean("l");
//        Integer port = arg.getInterget("p");
//        String dir = arg.getString("l");
//        //  then
//        assertThat(logging).isTrue();
//        assertThat(port).isEqualTo(8080);
//        assertThat(dir).isEqualTo("user/local");
    }

    @Test(expected = ArgsException.class)
    public void should_throw_when_schem_is_not_letter() {
        //  given
        //  when
        Args arg = new Args("2,p#,d*", new String[]{"-l","-p","8080","-d","user/local"});
        //  then
    }
}