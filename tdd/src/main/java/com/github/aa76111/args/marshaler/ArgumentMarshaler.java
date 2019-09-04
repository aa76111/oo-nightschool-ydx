package com.github.aa76111.args.marshaler;

import com.github.aa76111.args.ArgsException;

import java.util.Iterator;

public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}
