package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")

public class TMessages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "dateMsg", columnDefinition = "timestamp")
    private Date dateMsg;

    private TUsers sender;

    private TUsers receiver;
}
