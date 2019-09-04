package com.github.aa76111.args.marshaler;

import java.util.Iterator;
import java.util.Objects;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int intValue = 0;
    @Override
    public void set(Iterator<String> currentArgument) {
        String param = currentArgument.next();
        intValue = Integer.parseInt(param);
    }

    public static int getValue(ArgumentMarshaler am) {
        if (Objects.nonNull(am) && am instanceof IntegerArgumentMarshaler) {
            return ((IntegerArgumentMarshaler) am).intValue;
        }
        return 0;
    }
}
