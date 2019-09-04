package com.github.aa76111.args;
import org.junit.Test;

public class SchemaTest {

    @Test(expected = ArgsException.class)
    public void should_throw_when_schema_line_input_error() {
        //  given
        //  when
        new Schema("1,2,3");
        //  then
    }
}