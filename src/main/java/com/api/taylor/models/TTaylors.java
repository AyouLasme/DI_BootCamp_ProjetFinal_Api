package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


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

    public TTaylors(long id, String firstname, String lastname, String email, String tel, String password, Date birthdate, boolean taylor, boolean customer, boolean admin, String sexe, String category, String galery, boolean isAvailable) {
        super(id, firstname, lastname, email, tel, password, birthdate, taylor, customer, admin, sexe);
        this.category = category;
        this.galery = galery;
        this.isAvailable =isAvailable;
    }

}
