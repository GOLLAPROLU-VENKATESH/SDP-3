package com.sdp3.SDP3.entites;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class Orders {

    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_sequence"
    )
    private Long myOrderId;
    private String orderId;
    private String orderAmount;
    private String orderReceipt;
    private String orderStatus;
    private Long orderedStoreId;
    private Long userId;
    private Long productId;
    private String paymentId;
    private String orderAddress;
}
