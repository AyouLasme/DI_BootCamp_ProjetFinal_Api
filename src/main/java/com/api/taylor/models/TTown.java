package com.api.taylor.models;

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
@Table(name = "towns")
public class TTown implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String libelle;

    /*jointure unidirectionnelle de  la classe TTown avec  la classe TCity
    une ville peut avoir une ou plusieurs communes*/
  // @OneToMany(mappedBy = "town", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   // private List<TCity> cities;
}
