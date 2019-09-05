package com.github.aa76111.args;

import com.github.aa76111.args.marshaler.BooleanArgumentMarshaler;
import com.github.aa76111.args.marshaler.IntegerArgumentMarshaler;
import com.github.aa76111.args.marshaler.StringArgumentMarshaler;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SchemaTest {

    @Test(expected = ArgsException.class)
    public void should_throw_when_schema_line_input_error() {
        //  given
        //  when
        new Schema("1,2,3");
        //  then
    }

    @Test(expected = ArgsException.class)
    public void should_throw_when_parse_schema() {
        //  given
        //  when
        new Schema("l,p#,d*,tx");
        //  then
    }

    @Test
    public void should_parse_schema_correct_when_input_correct() {
        //  given
        //  when
        Schema schema = new Schema("l,p#,d*");
        //  then
        assertThat(schema.getMarshalers().size()).isEqualTo(3);
        assertThat(schema.getMarshalers().get('l')).isEqualToComparingFieldByField(new BooleanArgumentMarshaler());
        assertThat(schema.getMarshalers().get('p')).isEqualToComparingFieldByField(new IntegerArgumentMarshaler());
        assertThat(schema.getMarshalers().get('d')).isEqualToComparingFieldByField(new StringArgumentMarshaler());
    }
}