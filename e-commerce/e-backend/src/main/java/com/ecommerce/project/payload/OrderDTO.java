package com.ecommerce.project.payload;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long orderId;
    private String email;
    private List<OrderItemDTO> orderItems;
    private LocalDate orderDate;
    private PaymentDTO payment;
    private Double totalAmount;
    private String orderStatus;
    private Long addressId;


}
