package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;


@Getter
@Setter
@Table(name = "customers")
@Entity
@DiscriminatorValue("Customer")
@JsonIdentityInfo(scope = TCustomers.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TCustomers extends TUsers {
    public TCustomers() {
    }


    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TDemandes> sentDemandes;

}
