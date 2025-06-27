package com.ecommerce.project.payload;

import lombok.*;

@Getter@Setter@NoArgsConstructor
@AllArgsConstructor@ToString
public class PaymentDTO {

    private Long paymentId;
    private String paymentMethod;
    private String pgPaymentId;
    private String pgStatus;
    private String pgResponseMessage;
    private String pgName;

}
