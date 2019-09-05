package com.github.aa76111.args;

import com.github.aa76111.args.enumeration.SchemaTail;
import com.github.aa76111.args.marshaler.ArgumentMarshaler;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Schema {
    private Map<Character, ArgumentMarshaler> marshalers;

    public Schema(String schemaLine) {
        marshalers = new HashMap<>();
        Arrays.stream(schemaLine.split(","))
                .map(String::trim)
                .filter(StringUtils::isNotBlank)
                .forEach(this::parseSchemaElement);
    }

    private void parseSchemaElement(String element) throws ArgsException {
        char elementId = getSchemaElementId(element);
        marshalers.put(elementId, SchemaTail.getArgumentMarshaler(element.substring(1)));
    }

    private char getSchemaElementId(String element) throws ArgsException {
        char elementId = element.charAt(0);
        if (!Character.isLetter(elementId)) {
            throw new ArgsException("参数必须是字母");
        }
        return elementId;
    }

    public Map<Character, ArgumentMarshaler> getMarshalers() {
        return marshalers;
    }
}
