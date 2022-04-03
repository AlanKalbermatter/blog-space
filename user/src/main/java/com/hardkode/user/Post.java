package com.hardkode.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @SequenceGenerator(
            name = "post_id_sequence",
            sequenceName = "post_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_id_sequence"
    )
    private Long id;

    @Column(
            name = "user",
            nullable = false
    )
    private String user;

    @Column(
            name = "content",
            nullable = false
    )
    @Size(max = 220, message = "Maximum size reached")
    private String content;

}
