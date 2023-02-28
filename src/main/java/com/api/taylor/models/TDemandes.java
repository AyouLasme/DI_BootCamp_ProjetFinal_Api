package com.api.taylor.models;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "dateDmd", columnDefinition = "timestamp")
    private Date dateDmd;

    private String object;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    private  TUsers sender;

    private TUsers receiver;


    /*jointure unidirectionnelle de  la classe TDemandes avec  la classe TImages
    une demande peut avoir une ou plusieurs images*/
    @OneToMany(targetEntity = TImages.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "demandes_fk",referencedColumnName = "id")
    private List<TImages> images;

}
