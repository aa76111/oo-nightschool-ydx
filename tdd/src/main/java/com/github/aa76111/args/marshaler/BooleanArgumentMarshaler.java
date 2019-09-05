package com.github.aa76111.args.marshaler;

import java.util.Iterator;
import java.util.Objects;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    @Override
    public void set(String argVal) {
        booleanValue = true;
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (Objects.nonNull(am) && am instanceof BooleanArgumentMarshaler) {
            return ((BooleanArgumentMarshaler) am).booleanValue;
        }
        return false;
    }

    
}
