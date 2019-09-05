package com.github.aa76111.args.marshaler;

import com.github.aa76111.args.ArgsException;

public interface ArgumentMarshaler {
    void set(String argVal) throws ArgsException;
}
