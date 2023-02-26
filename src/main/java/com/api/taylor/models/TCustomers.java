package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@Table(name = "customers")
@Entity
@DiscriminatorValue("customer")
public class TCustomers extends TUsers {
    public TCustomers() {
    }

    public TCustomers(long id, String firstname, String lastname, String email, String tel, String password, Date birthdate, boolean taylor, boolean customer, boolean admin, String sexe) {
        super(id, firstname, lastname, email, tel, password, birthdate, taylor, customer, admin, sexe);
    }
}
