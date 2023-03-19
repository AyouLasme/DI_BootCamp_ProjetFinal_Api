package com.api.taylor.models;

import com.fasterxml.jackson.annotation.*;
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
@NamedQuery(name = "TDemandes.findByMunicipality", query = "SELECT d FROM TDemandes d WHERE d.municipality.id = ?1")
@NamedQuery(name = "TDemandes.findBySender", query = "SELECT d FROM TDemandes d WHERE d.sender.id = ?1")
@NamedQuery(name = "TDemandes.findByReceiver", query = "SELECT d FROM TDemandes d WHERE d.receiver.id = ?1")

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
    private List<TReponse> reponses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDmd() {
        return dateDmd;
    }

    public void setDateDmd(Date dateDmd) {
        this.dateDmd = dateDmd;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TCustomers getSender() {
        return sender;
    }

    public void setSender(TCustomers sender) {
        this.sender = sender;
    }

    @Nullable
    public TTaylors getReceiver() {
        return receiver;
    }

    public void setReceiver(@Nullable TTaylors receiver) {
        this.receiver = receiver;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TMunicipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(TMunicipality municipality) {
        this.municipality = municipality;
    }

    public List<TImages> getImages() {
        return images;
    }

    public void setImages(List<TImages> images) {
        this.images = images;
    }

    public List<TReponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<TReponse> reponses) {
        this.reponses = reponses;
    }
}



