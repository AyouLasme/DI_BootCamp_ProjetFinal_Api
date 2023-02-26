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
@Table(name = "customers")
@Entity
@DiscriminatorValue("customer")
public class TCustomers extends TUsers {
    public TCustomers() {
    }


    /*jointure unidirectionnelle de  la classe TCustomers avec  la classe TDemandes
    un client peut faire une ou plusieurs demandes*/
    @OneToMany(targetEntity = TDemandes.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "customers_fk",referencedColumnName = "id")
    private List<TDemandes> demandes;

}
