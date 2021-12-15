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
public class Blog {
    @Id
    @SequenceGenerator(
            name = "blog_id_sequence",
            sequenceName = "blog_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blog_id_sequence"
    )
    private Long blogId;
    private String blogTitle;
    private String blogDescription;
    private String blogVideo;
}
