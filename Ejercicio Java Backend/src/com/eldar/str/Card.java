package com.eldar.str;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Card {
    public BigDecimal numCard;
    public String brand;
    public String cardHolder;
    public Date expirationDate;
        SimpleDateFormat dateTransformer = new SimpleDateFormat("dd/MM/yyyy");
        public Card (BigDecimal numCard, String brand, String cardHolder, Date expirationDate) {
            this.numCard = numCard;
            this.brand = brand;
            this.cardHolder = cardHolder;
            this.expirationDate = expirationDate;
        }
        public boolean isValid() {
            Date currentDate = new Date();
             return  currentDate.after(this.expirationDate);
        }
        public String getBrand() {
            return brand;
        }
        @Override
        public String toString() {
            return "The card number is: " + numCard + "\n"+ brand + ", Cardholder is: " + cardHolder
                    + "\n" + dateTransformer.format(expirationDate) ;
        }
}