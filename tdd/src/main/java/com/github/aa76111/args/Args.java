package com.github.aa76111.args;

public class Args {

    public Args(String schemaLine, String[] args) {
        Schema schema = new Schema(schemaLine);
        parseArgs(args);
    }


    private void parseArgs(String[] args) {
    }
}
