package com.github.aa76111.args.marshaler;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Objects;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String strVal = StringUtils.EMPTY;

    @Override
    public void set(Iterator<String> currentArgument) {
        strVal = currentArgument.next();
    }

    public static String getValue(ArgumentMarshaler am) {
        if (Objects.nonNull(am) && am instanceof StringArgumentMarshaler) {
            return ((StringArgumentMarshaler) am).strVal;
        }
        return StringUtils.EMPTY;
    }
}
