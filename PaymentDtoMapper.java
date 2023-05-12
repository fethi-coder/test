package fr.sciam;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

@Builder
@Data
public class PaymentDtoMapper implements Function<Payment, PaymentDto> {

    public PaymentDtoMapper(
            boolean randomIsFee,
            BigDecimal bigDecimal
    ) {
    }

    public PaymentDtoMapper() {
    }



    @Override
    public PaymentDto apply(Payment payment) {
        return new PaymentDto(
                payment.isFee(),
                payment.getAmount()
        );

    }
}
