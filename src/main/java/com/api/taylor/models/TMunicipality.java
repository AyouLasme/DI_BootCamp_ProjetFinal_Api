package com.api.taylor.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "municipalities")
public class TMunicipality implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    private String libelle;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "city_fk",referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TCity city;


    /*jointure unidirectionnelle de  la classe TMunicipality avec  la classe TUser
    une commune peut appartenir à un ou plusieurs utilisateurs*/
    @OneToMany(mappedBy = "municipality", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TUsers> users;

}
