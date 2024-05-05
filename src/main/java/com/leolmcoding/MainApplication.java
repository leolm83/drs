package com.leolmcoding;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainApplication {
    private static final String RESOURCES = "src/main/resources";
    public static void main(String[] args) throws Exception {
        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES,fileName);
        final BankStatementAnalyzer bankStatementAnalizer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalizer.analyze(path,bankStatementParser);
    }
}
