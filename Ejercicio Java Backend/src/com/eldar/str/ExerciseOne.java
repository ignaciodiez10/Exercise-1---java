package com.eldar.str;

import java.math.BigDecimal;
import java.util.Date;

public class ExerciseOne {
        public static void main(String[] args) {
            Date duedate = new Date(2023, 2, 26);
            Date duedate1 = new Date(126, 1, 3);
            Date duedate2 = new Date(127, 5, 15);

            Card card = new Card(new BigDecimal(1234567891), "VISA", "Pablo Elena", duedate);
            Card card1 = new Card(new BigDecimal(987654321), "NARA", "Ignacio Diez", duedate1);
            Card card2 = new Card(new BigDecimal( 987654332), "AMEX", "Juan Carlo", duedate2);

            System.out.println(card1);
            System.out.println(card1.isValid());

            ValidationOperation op = new ValidationOperation(new BigDecimal(999), card1);
            System.out.println(op.rateYMark());
            System.out.println(op.isValidOperation());
        }
    }