package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")

public class TMessages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "dateMsg", columnDefinition = "datetime")
    private String dateMsg;

    private TUsers sender;

    private TUsers receiver;
}
