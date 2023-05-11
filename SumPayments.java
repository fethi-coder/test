package fr.sciam;


import org.jetbrains.annotations.TestOnly;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SumPayments {

    public static void main(String[] args) {

        Payment ex = new Payment(BigDecimal.valueOf(234), true);
        Payment ex1 = new Payment(BigDecimal.valueOf(234.90), false);
        Payment ex2 = new Payment(BigDecimal.valueOf(678.9), false);
        List<Payment> listObject = List.of(ex, ex1, ex2);
        sumNonFeePayments(listObject);
    }

    public static BigDecimal sumNonFeePayments(List<Payment> payments) {
        Map<Integer, BigDecimal> array = new HashMap<>();
        BigDecimal total = BigDecimal.valueOf(0);
        Integer count = 0;
        for (Payment payment : payments) {
            if (!payment.isFee()) {
                array.put(count, payment.getAmount());
                total = array.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
                count++;
            }
        }
        System.out.println(total);
        return total;
    }
}
