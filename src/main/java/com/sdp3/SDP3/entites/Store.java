package com.sdp3.SDP3.entites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class Store {
    @Id
    @SequenceGenerator(
            name = "store_id_sequence",
            sequenceName = "store_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "store_id_sequence"
    )
    private Long storeId;
    private String storeName;
    private String phoneNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id",referencedColumnName = "userId")
    private Users users;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "store_id",
            referencedColumnName = "storeId"
    )
    private List<Blog> blogs;
}
