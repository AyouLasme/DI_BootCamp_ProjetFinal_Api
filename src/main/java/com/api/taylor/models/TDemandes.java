package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demandes")

public class TDemandes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "dateDmd", columnDefinition = "timestamp")
    private Date dateDmd;

    private String object;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "sender_fk", referencedColumnName = "id")
    private TUsers sender;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "reveiver_fk", referencedColumnName = "id")
    private TUsers receiver;


    /*jointure unidirectionnelle de  la classe TDemandes avec  la classe TImages
    une demande peut avoir une ou plusieurs images*/
    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    private List<TImages> images;

}
