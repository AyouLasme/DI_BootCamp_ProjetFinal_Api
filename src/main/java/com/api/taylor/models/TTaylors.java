package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "taylors")
@DiscriminatorValue("taylor")

public class TTaylors extends TUsers {

    @Column(name = "category", length = 60)
    private String category;

    @Column(name = "galery", length = 60)
    private String galery;

    private boolean isAvailable;

    public TTaylors() {
        super();
    }

    public TTaylors(long id, String firstname, String lastname, String email, String tel, String password, Date birthdate, boolean taylor, boolean customer, boolean admin, String sexe, List<TMessages> messages, String category, String galery, boolean isAvailable) {
        super(id, firstname, lastname, email, tel, password, birthdate, taylor, customer, admin, sexe, messages);
        this.category = category;
        this.galery = galery;
        this.isAvailable = isAvailable;
    }


    /*jointure unidirectionnelle de  la classe TUsers avec  la classe TMessages
       un tailleur peut avoir une ou plusieurs demandes*/
    @OneToMany(targetEntity = TDemandes.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "taylor_fk",referencedColumnName = "id")
    private List<TDemandes> demandes;


    /*jointure unidirectionnelle de  la classe TUsers avec  la classe TImages
       un tailleur peut avoir une ou plusieurs images dans ses realisations*/
    @OneToMany(targetEntity = TImages.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "taylor_fk",referencedColumnName = "id")
    private List<TImages> images;

}
