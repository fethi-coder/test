package fr.sciam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.function.Function;

@Builder
@Data
public class PaymentDtoMapper implements Function<Payment, PaymentDto> {

    public PaymentDtoMapper(boolean randomIsFee, BigDecimal bigDecimal) {
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
