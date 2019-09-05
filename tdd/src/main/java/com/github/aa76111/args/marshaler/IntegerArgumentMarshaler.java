package com.github.aa76111.args.marshaler;

import java.util.Objects;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int intValue = 0;
    @Override
    public void set(String argVal) {
        intValue = Integer.parseInt(argVal);
    }

    public static int getValue(ArgumentMarshaler am) {
        if (Objects.nonNull(am) && am instanceof IntegerArgumentMarshaler) {
            return ((IntegerArgumentMarshaler) am).intValue;
        }
        return 0;
    }
}
