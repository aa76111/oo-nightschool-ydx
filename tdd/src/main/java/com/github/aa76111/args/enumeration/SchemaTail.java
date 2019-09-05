package com.github.aa76111.args.enumeration;

import com.github.aa76111.args.ArgsException;
import com.github.aa76111.args.marshaler.ArgumentMarshaler;
import com.github.aa76111.args.marshaler.BooleanArgumentMarshaler;
import com.github.aa76111.args.marshaler.IntegerArgumentMarshaler;
import com.github.aa76111.args.marshaler.StringArgumentMarshaler;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

public enum SchemaTail {
    BOOLEAN(StringUtils.EMPTY, BooleanArgumentMarshaler.class),
    INTEGER("#", IntegerArgumentMarshaler.class),
    STRING("*", StringArgumentMarshaler.class);

    private Object tail;
    private Class<? extends ArgumentMarshaler> clazz;

    SchemaTail(Object tail, Class<? extends ArgumentMarshaler> clazz) {
        this.tail = tail;
        this.clazz = clazz;
    }

    public static ArgumentMarshaler getArgumentMarshaler(String tail) {
        return Arrays.stream(SchemaTail.values())
                .filter(schemaTail -> Objects.equals(tail, schemaTail.tail))
                .findFirst()
                .map(schemaTail -> {
                    ArgumentMarshaler argumentMarshaler = null;
                    try {
                        argumentMarshaler = schemaTail.clazz.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return argumentMarshaler;
                })
                .orElseThrow(() -> new ArgsException("unexpected schema"));
    }
}
