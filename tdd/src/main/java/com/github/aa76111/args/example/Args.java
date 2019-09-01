package com.github.aa76111.args.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Args {

    private HashMap<String, ArgumentMarshaler> marshalers;
    private HashSet<Character> argsFound;

    public Args(String schema, String[] args) throws ArgsException {
        marshalers = new HashMap<>();
        argsFound = new HashSet<>();
        parseSchema(schema);
        parseArgs(Arrays.asList(args));
        
    }

    private void parseSchema(String schema) {
        Arrays.stream(schema.split(","))
                .filter(element -> element.length() > 0 )
                .forEach(element -> parseSchemaElement(element.trim()));
    }

    private void parseSchemaElement(String element) {

    }

    private void parseArgs(List<String> args) {

    }
}
