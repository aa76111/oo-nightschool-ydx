package com.github.aa76111.args;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Schema {
    private Map<Character, ArgMarshaler> marshalers;

    public Schema(String schemaLine) {
        marshalers = new HashMap<>();
        Arrays.stream(schemaLine.split(","))
                .map(String::trim)
                .filter(StringUtils::isNotBlank)
                .forEach(element -> {
                    parseSchemaElement(element);
                });
    }

    private void parseSchemaElement(String element) {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
//        switch (elementTail) {
//            case "":
//                marshalers.put(elementId, new BooleanArgMarshaler());
//                return;
//            default:
//                return;
//        }
    }

    private void validateSchemaElementId(char elementId) {
        if (!Character.isLetter(elementId)) {
            throw new IllegalArgumentException("参数必须是字母");
        }
    }
}
