package com.github.aa76111.args.example;

public interface ArgumentMarshaler {
    void set(Iterable<String> currentArgument) throws ArgsException;
}
