package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "demandes")
@JsonIdentityInfo(scope = TDemandes.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TDemandes implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "dateDmd", columnDefinition = "timestamp")
    private Date dateDmd;

    @Column(name = "dateRetrait", columnDefinition = "timestamp")
    private Date dateRetrait;

    private String object;

    /*
     * les valeus possibles du statut: Annonce, Traitement, Terminé, Annulé
     * */
    private String statut;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "sender_fk", referencedColumnName = "id")
    private TCustomers sender;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receiver_fk", referencedColumnName = "id")
    @Nullable
    private TTaylors receiver;

    @Column(name = "category")
    private String category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "municipality_fk", referencedColumnName = "id")
    private TMunicipality municipality;


    /*jointure unidirectionnelle de  la classe TDemandes avec  la classe TImages
   une demande peut avoir une ou plusieurs images*/
    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TImages> images;

    /*jointure unidirectionnelle de  la classe TDemandes avec  la classe TReponse
    une demande peut avoir une ou plusieurs reponses*/
    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TReponse> reponses;

}



