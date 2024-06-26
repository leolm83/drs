package com.leolmcoding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementAnalyzer {
   
    private static final BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();


    public void analyze(final Path path,final BankStatementParser bankStatementParser)throws Exception{
         final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    
    }
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
        System.out.println("The total of all transactions is "+bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is "+ bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is "+ bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary recieved is "+ bankStatementProcessor.calculateTotalForCategory("Salary"));
        

    }

}