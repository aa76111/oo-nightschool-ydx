package com.github.aa76111.args.example;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {

    private Args arg;


    @Before
    public void setUp() throws ArgsException {
//        String[] args = new String [] {"-l","-p","8080","-d","/usr/local"};
        String[] args = new String [] {"-lp","8080","-d","/usr/local"};
        arg = new Args("l,p#,d*", args);
    }

    @Test
    public void should_analysis_args_successfully() {
        //  given
        //  when
        Boolean logging = arg.getBoolean('l');
        int port = arg.getInt('p');
        String directory = arg.getString('d');
//          then
        assertThat(logging).isTrue();
        assertThat(port).isEqualTo(8080);
        assertThat(directory).isEqualTo("/usr/local");
//        assertThat(123).isEqualTo(123);
    }

    @Test
    public void should_parse_schema_correct_successfully() {
        //  given
        //  when

        //  then
        assertThat(arg.getBoolean('l')).isEqualTo(true);
        assertThat(arg.getInt('p')).isEqualTo(0);
        assertThat(arg.getString('d')).isEqualTo(StringUtils.EMPTY);
    }
}