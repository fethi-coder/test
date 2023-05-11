package fr.sciam;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private boolean isFee;
    private BigDecimal amount;
}
