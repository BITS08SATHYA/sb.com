package com.ecommerce.project.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StripePaymentDto {

    private Long amount;
    private String currency;

}
