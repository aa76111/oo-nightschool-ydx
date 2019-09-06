package com.github.aa76111.args;

import com.github.aa76111.args.marshaler.ArgumentMarshaler;
import com.github.aa76111.args.marshaler.BooleanArgumentMarshaler;
import com.github.aa76111.args.marshaler.IntegerArgumentMarshaler;
import com.github.aa76111.args.marshaler.StringArgumentMarshaler;
import io.reactivex.Observable;
import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;

public class Args {

    private Map<Character, ArgumentMarshaler> marshalers;

    public Args(String schemaLine, String[] args) {
        marshalers = new Schema(schemaLine).getMarshalers();
        parseArgs(args);
    }


    private void parseArgs(String[] args) {
        Arrays.stream(args).filter(StringUtils::isNotBlank).forEach(this::parseArgs);
    }

    private void parseArgs(String arg) {
        Observable.just(arg)
                .filter(this::validateArg)
                .map(this::splitArg)
                .doOnNext(pair -> marshalers.get(pair.getKey()).set(pair.getValue()))
                .doOnError(error -> new ArgsException("error: " + error.getMessage()))
                .subscribe();
    }

    private Pair<Character, String> splitArg(String a) {
        return new Pair<>(a.charAt(1), StringUtils.replace(a, "-" + a.charAt(1) + "=", StringUtils.EMPTY));
    }

    private boolean validateArg(String arg) {
        if (arg.startsWith("-") && arg.contains("=")) {
            return true;
        }
        throw new ArgsException("arg 解析错误: " + arg);
    }

    public Boolean getBoolean(char argChar) {
        return BooleanArgumentMarshaler.getValue(marshalers.get(argChar));
    }

    public Integer getInteger(char argChar) {
        return IntegerArgumentMarshaler.getValue(marshalers.get(argChar));
    }

    public String getString(char argChar) {
        return StringArgumentMarshaler.getValue(marshalers.get(argChar));
    }
}
