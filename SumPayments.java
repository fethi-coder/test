package fr.sciam;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumPayments {

    public static void main(String[] args) {
        creationList();
    }

    public static List<PaymentDto> creationList() {
        boolean randomIsFee;
        int max = 100;
        int min = -100;
        int range = max - min + 1;
        PaymentDto ex = new PaymentDto();
        PaymentDto ex1 = new PaymentDto();
        List<PaymentDto> listObject = new ArrayList<>();
        int count = 0;
        while (count < 1000) {
            int randomCond = (int) (Math.random() * range) + min;
            if (randomCond % 2 == 0) {
                randomIsFee = true;
                ex = new PaymentDto(randomIsFee, BigDecimal.valueOf(Math.random() * 1000));
                listObject.add(ex);
                count++;
            } else {
                randomIsFee = false;
                ex1 = new PaymentDto(randomIsFee, BigDecimal.valueOf(Math.random() * 1000));
                listObject.add(ex1);
                count++;
            }
        }
        resultFalse(listObject);
        sumNonFeePayments(listObject);
        return listObject;
    }

    private static final DecimalFormat df = new DecimalFormat("0.000");

    public static String sumNonFeePayments(List<PaymentDto> payments) {
        PaymentDtoMapper paymentDtoMapper;
        Map<Integer, BigDecimal> array = new HashMap<>();
        BigDecimal total = BigDecimal.valueOf(0);
        Integer count = 0;
        for (PaymentDto payment : payments) {
            if (payment.isFee()) {
                array.put(count, payment.getAmount());
                total = array.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
                count++;
            }
        }
        Message message = new Message("la valeur true total est de : ", total);
        System.out.println(message.getMessage() + df.format(message.getPayment()));
        return message.getMessage() + message.getPayment();

    }

    public static String resultFalse(List<PaymentDto> payments) {
        LinkedList<BigDecimal> nullResul = new LinkedList<>();
        BigDecimal total = BigDecimal.valueOf(0);
        for (PaymentDto payment : payments) {
            if (!payment.isFee()) {
                nullResul.add(payment.getAmount());
                total = nullResul.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            }
        }
        Message message = new Message("la valeur false total est de : ", total);
        System.out.println(message.getMessage() + df.format(message.getPayment()));
        return message.getMessage() + message.getPayment();
    }
}


