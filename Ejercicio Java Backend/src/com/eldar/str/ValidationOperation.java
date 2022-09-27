package com.eldar.str;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ValidationOperation {
    private String validity;
    private BigDecimal consumption;
    private Double tax;
    private Card card;
    final static int MAX_CONSUMPTION = 1000;
    public ValidationOperation(BigDecimal consumption, Card card) {
        this.consumption =consumption;
        this.card = card;
    }
    public boolean isValidOperation() {
        return this.consumption.compareTo(BigDecimal.valueOf(MAX_CONSUMPTION)) < 0;
    }
    SimpleDateFormat convertYear = new SimpleDateFormat("yy");
    public BigDecimal rateYMark() {
        if (card.getBrand().equalsIgnoreCase("VISA")) {
            BigDecimal taxVisa = BigDecimal.valueOf(Double.parseDouble(convertYear.format(LocalDate.now().getYear())) / (double) (LocalDate.now().getMonthValue()/100));
            return this.consumption.multiply(taxVisa);
        }
        else if (card.getBrand() =="AMEX") {
            BigDecimal taxAmex = BigDecimal.valueOf(Double.parseDouble(convertYear.format(LocalDate.now().getMonthValue() * 0.1)) /100 );
            return this.consumption.multiply(taxAmex);
        }
        else if (card.getBrand() == "NARA") {
            BigDecimal taxNara = BigDecimal.valueOf(Double.parseDouble(convertYear.format(LocalDate.now().getDayOfMonth() * 0.5)) /100 );
            return this.consumption.multiply(taxNara);
        }else {
            throw new IllegalArgumentException("Brand not found");
        }
    }
}