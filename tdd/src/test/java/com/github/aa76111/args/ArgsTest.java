package com.github.aa76111.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {

    @Test
    public void should_analysis_args_correct_successfully() {
        //  given
        Args arg = new Args("l,p#,d*", new String[]{"-l=","-p=8080","-d=user/local"});
        //  when
        Boolean logging = arg.getBoolean('l');
        Integer port = arg.getInteger('p');
        String dir = arg.getString('d');
        //  then
        assertThat(logging).isTrue();
        assertThat(port).isEqualTo(8080);
        assertThat(dir).isEqualTo("user/local");
    }
}