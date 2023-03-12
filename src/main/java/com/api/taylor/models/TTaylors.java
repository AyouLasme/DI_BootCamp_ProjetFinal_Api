package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "taylors")
@DiscriminatorValue("taylor")

public class TTaylors extends TUsers {

    @Column(name = "category", length = 60)
    private String category;

    @Column(name = "galery", length = 60)
    private String galery;

    private boolean isAvailable;




    /*jointure unidirectionnelle de  la classe TUsers avec  la classe TMessages
           un tailleur peut avoir une ou plusieurs demandes*/
    @OneToMany(targetEntity = TDemandes.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "demande_fk",referencedColumnName = "id")
    private List<TDemandes> demandes;


    /*jointure unidirectionnelle de  la classe TUsers avec  la classe TImages
       un tailleur peut avoir une ou plusieurs images dans ses realisations*/
    @OneToMany(targetEntity = TImages.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "image_fk",referencedColumnName = "id")
    private List<TImages> images;


   /*jointure bidirectionnelle de  la classe TTaylors avec  la classe TCompetencies
       un tailleur peut avoir une ou plusieurs competences et une competences peut appartenir
         à un ou plusieurs tailleurs */

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "taylors-competencies",
            joinColumns = @JoinColumn(name = "taylors_id"),
            inverseJoinColumns = @JoinColumn(name = "competencies_id")
    )
    private Set<TCompetencies> competencies = new HashSet<>();

}
