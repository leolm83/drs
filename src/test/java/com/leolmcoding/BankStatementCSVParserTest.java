package com.leolmcoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest{
    private final BankStatementParser bankStatementParser= new BankStatementCSVParser();
    @Test
    public void shouldParseOneCorrectLine() throws Exception{
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction bankTransaction = bankStatementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY,30),-50,"Tesco");
        final double tolerance = 0.0d;
        Assertions.assertEquals(expected.getDate(),bankTransaction.getDate());
        Assertions.assertEquals(expected.getAmount(),bankTransaction.getAmount(),tolerance);
        Assertions.assertEquals(expected.getDescription(),bankTransaction.getDescription());
    }
}

