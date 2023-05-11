package fr.sciam;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumPayments {

    public static void main(String[] args) {
        creationList();
}

    public static List<Payment> creationList() {
        boolean randomIsFee;
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        Payment ex = new Payment();
        Payment ex1 = new Payment();
        List<Payment> listObject =  new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int randomCond = (int)(Math.random() * range) + min;
            if (randomCond % 2 == 0) {
                randomIsFee = true;
                ex = new Payment(randomIsFee, BigDecimal.valueOf(Math.random() * 1000));
                listObject.add(ex);
            } else {
                randomIsFee = false;
                ex1 = new Payment(randomIsFee, BigDecimal.valueOf(Math.random() * 1000));
                listObject.add(ex1);
            }
        }
        resultFalse(listObject);
        sumNonFeePayments(listObject);
        return listObject;
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
        Message message = new Message("la valeur true total est de : ", total);
        System.out.println(message.getMessage() + Math.round(message.getPayment().doubleValue()));
        return message.getMessage() + message.getPayment();

    }

    public static String resultFalse(List<Payment> payments) {
        LinkedList<BigDecimal> nullResul = new LinkedList<>();
        BigDecimal total = BigDecimal.valueOf(0);
        for (Payment payment : payments) {
            if (!payment.isFee()) {
                nullResul.add(payment.getAmount());
                total = nullResul.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            }
        }
        Message message = new Message("la valeur false total est de : ", total);
        System.out.println(message.getMessage() + Math.round(message.getPayment().doubleValue()));
        return message.getMessage() + message.getPayment();
    }
}


