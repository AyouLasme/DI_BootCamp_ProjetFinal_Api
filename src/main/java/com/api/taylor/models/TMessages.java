package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
//@NamedQuery(name = "TMessages.findBySenderDemande", query = "SELECT r FROM TMessage r WHERE r.demande.id=?1 AND r.sender.id=?2")
@JsonIdentityInfo(scope = TMessages.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TMessages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Column(name = "dateMsg", columnDefinition = "timestamp")
    private Date dateMsg;

    @ManyToOne()
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "reveiver_fk", referencedColumnName = "id")
    private TUsers sender;

    @ManyToOne()
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "sender_fk", referencedColumnName = "id")
    private TUsers receiver;



}
