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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class TCity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String libelle;

    /*jointure unidirectionnelle de  la classe TCity avec  la classe TUser
    une commune peut contenir un ou plusieurs utilisateurs*/
    @OneToMany(targetEntity = TUsers.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "city_fk",referencedColumnName = "id")
    private List<TUsers> users;
}
