package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.annotation.Nullable;
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
@DiscriminatorValue("Taylor")
@JsonIdentityInfo(scope = TTaylors.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class TTaylors extends TUsers {

    @Column(name = "category", length = 60)
    private String category;

    @Column(name = "galery", length = 60)
    private String galery;

    private boolean isAvailable = true;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
//    @JsonIdentityReference(alwaysAsId = true)
    @JsonBackReference
    private List<TDemandes> receivedDemandes;



    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TReponse> reponses ;




    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "competencies_users",
            joinColumns = @JoinColumn( name = "user_fk" ),
            inverseJoinColumns = @JoinColumn( name = "competency_fk" ) )
    private List<TCompetencies> competencies;




}
