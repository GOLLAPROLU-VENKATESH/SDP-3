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
public class Wallet {
    @Id
    @SequenceGenerator(
            name = "wallet_id_sequence",
            sequenceName = "wallet_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wallet_id_sequence"
    )
    private Long walletId;
    private Long walletBalance;
    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "store_id",referencedColumnName = "storeId")
    private Store store;
}
