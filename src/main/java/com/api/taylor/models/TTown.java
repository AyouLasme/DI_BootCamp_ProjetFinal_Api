package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "towns")
public class TTown {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String libelle;

    /*jointure unidirectionnelle de  la classe TTown avec  la classe TCity
    une ville peut avoir une ou plusieurs communes*/
    @OneToMany(targetEntity = TCity.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "town_fk",referencedColumnName = "id")
    private List<TCity> cities;
}
