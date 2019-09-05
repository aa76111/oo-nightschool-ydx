package com.github.aa76111.args.marshaler;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String strVal = StringUtils.EMPTY;

    @Override
    public void set(String argVal) {
        strVal = argVal;
    }

    public static String getValue(ArgumentMarshaler am) {
        if (Objects.nonNull(am) && am instanceof StringArgumentMarshaler) {
            return ((StringArgumentMarshaler) am).strVal;
        }
        return StringUtils.EMPTY;
    }
}
