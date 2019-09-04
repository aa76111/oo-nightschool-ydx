package com.github.aa76111.args.enumeration;

import com.github.aa76111.args.marshaler.ArgumentMarshaler;
import com.github.aa76111.args.marshaler.BooleanArgumentMarshaler;
import com.github.aa76111.args.marshaler.IntegerArgumentMarshaler;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

public enum SchemaTail {
    BOOLEAN(StringUtils.EMPTY, BooleanArgumentMarshaler.class),
    INTEGER("#", IntegerArgumentMarshaler.class);

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
//                        log.error("转换类型错误");
                        e.printStackTrace();
                    }
                    return argumentMarshaler;
                })
                .orElse(null);
    }
}
