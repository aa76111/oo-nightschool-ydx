package com.github.aa76111.args.example;

import java.util.*;

import static com.github.aa76111.args.example.ErrorCode.INVALID_ARGUMENT_FORMAT;
import static com.github.aa76111.args.example.ErrorCode.UNEXPECTED_ARGUMENT;

public class Args {

    private HashMap<Character, ArgumentMarshaler> marshalers;
    private HashSet<Character> argsFound;
    private ListIterator<String> currentArgument;

    public Args(String schema, String[] args) throws ArgsException {
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

    private void parseArgs(List<String> args) throws ArgsException {
        for (currentArgument = args.listIterator(); currentArgument.hasNext();) {
            String argString = currentArgument.next();
            if (argString.startsWith("-")) {
                parseArgumentCharacters(argString.substring(1));
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argChars) throws ArgsException {
        for (int i = 0; i < argChars.length(); i++) {
            parseArgumentCharacter(argChars.charAt(i));
        }
    }

    private void parseArgumentCharacter(char argChar) throws ArgsException {
        ArgumentMarshaler am = marshalers.get(argChar);
        if (am == null) {
            throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
        } else {
            argsFound.add(argChar);
            am.set(currentArgument);
        }
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
