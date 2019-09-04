package com.github.aa76111.args.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static com.github.aa76111.args.example.ErrorCode.INVALID_ARGUMENT_FORMAT;

public class Args {

    private HashMap<Character, ArgumentMarshaler> marshalers;
    private HashSet<Character> argsFound;

    public Args(String schema, String[] args) {
        marshalers = new HashMap<>();
        argsFound = new HashSet<>();
        parseSchema(schema);
        parseArgs(Arrays.asList(args));
    }

    private void parseSchema(String schema) {
        Arrays.stream(schema.split(","))
                .filter(element -> element.length() > 0)
                .forEach(element -> {
                    try {
                        parseSchemaElement(element.trim());
                    } catch (ArgsException e) {
                        e.printStackTrace();
                    }
                });
    }

    private void parseSchemaElement(String element) throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        switch (elementTail) {
            case "":
                marshalers.put(elementId, new BooleanArgumentMarshaler());
                break;
            case "*":
                marshalers.put(elementId, new StringArgumentMarshaler());
                break;
            case "#":
                marshalers.put(elementId, new IntegerArgumentMarshaler());
                break;
            default:
                throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
        }
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId)) {
            throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, null);
        }
    }

    private void parseArgs(List<String> args) {

    }
//
//    public boolean has(char arg) {
//        return argsFound.contains(arg);
//    }
//
    public boolean getBoolean(char arg) {
        return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public String getString(char arg) {
        return StringArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public int getInt(char arg) {
        return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
    }
}
