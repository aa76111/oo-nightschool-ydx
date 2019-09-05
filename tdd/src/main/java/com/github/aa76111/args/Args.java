package com.github.aa76111.args;

import com.github.aa76111.args.marshaler.ArgumentMarshaler;
import io.reactivex.Observable;
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
                .map(a -> a.split("="))
                .doOnNext(a -> marshalers.get(a[0]).set(a[1]))
                .doOnError(error -> new ArgsException("error: " + error.getMessage()))
                .subscribe();
    }

    private boolean validateArg(String arg) {
        if (arg.startsWith("-") && arg.split("=").length == 2) {
            return true;
        }
        throw new ArgsException("arg 解析错误: " + arg);
    }
}
