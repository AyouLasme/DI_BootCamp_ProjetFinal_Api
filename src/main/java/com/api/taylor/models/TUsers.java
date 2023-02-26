package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.STRING)
public class TUsers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "firstname", length = 60 )
    protected String firstname;

    @Column(name = "lastname", length = 60 )
    protected  String lastname;

    @Column(name = "email", length = 150 )
    protected  String email;

    @Column(name = "tel", length = 20 )
    protected  String tel;

    @Column(name = "password", length = 10 )
    protected  String password;


    protected Date birthdate;

    @Column(name = "taylor", nullable = false, columnDefinition = "boolean default false")
    protected boolean taylor = false;

    @Column(name = "customer", nullable = false, columnDefinition = "boolean default false")
    protected boolean customer = false;

    @Column(name = "admin", nullable = false, columnDefinition = "boolean default false")
    protected boolean admin = false;

    @Column(name = "sexe", length = 1)
    protected  String sexe;


}
