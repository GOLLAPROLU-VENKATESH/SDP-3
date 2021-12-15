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
public class  Users {
        @Id
        @SequenceGenerator(
                name = "user_id_sequence",
                sequenceName = "user_id_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "user_id_sequence"
        )
        private Long userId;
        private String firstName;
        private String lastName;
        private String userName;
        private String phoneNumber;
        private String email;
        private String password;
}
