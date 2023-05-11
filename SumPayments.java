package fr.sciam;


import org.jetbrains.annotations.TestOnly;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumPayments {

    public static void main(String[] args) {

        Payment ex = new Payment(true, BigDecimal.valueOf(234));
        Payment ex1 = new Payment(true, BigDecimal.valueOf(234.90));
        Payment ex2 = new Payment(false, BigDecimal.valueOf(678.9));
        List<Payment> listObject = List.of(ex, ex1, ex2);
        List<Payment> listObjectNull = List.of();

        sumNonFeePayments(listObject);
        System.out.println(sumNonFeePayments(listObject));
        ResultFalse(listObject);
        System.out.println(ResultFalse(listObject));
    }


    public static String sumNonFeePayments(List<Payment> payments) {
        Map<Integer, BigDecimal> array = new HashMap<>();
        BigDecimal total = BigDecimal.valueOf(0);
        Integer count = 0;
            for (Payment payment : payments) {
                if (payment.isFee()) {
                    array.put(count, payment.getAmount());
                    total = array.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
                    count++;
                }
            }
        Message message =new Message("la valeur true total est de : ",total);
        return message.getMessage() + message.getPayment();
    }

    public static String ResultFalse(List<Payment> payments) {
        List<BigDecimal> nullResul = new LinkedList<>();
        BigDecimal total = BigDecimal.valueOf(0);
        Integer count = 0;
            for (Payment payment : payments) {
                if (!payment.isFee()) {
                    nullResul.add(count, payment.getAmount());
                    total = nullResul.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
                    count++;
                }
            }
        Message message =new Message("la valeur false total est de : ",total);
        return message.getMessage() + message.getPayment();
    }
}


