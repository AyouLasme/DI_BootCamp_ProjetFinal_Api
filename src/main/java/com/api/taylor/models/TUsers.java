package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "adresse", length = 20 )
    protected String adresse;

    @Column(name = "role", length = 10)
    protected String role = "";


    @Column(name = "admin", nullable = false, columnDefinition = "boolean default false")
    protected boolean admin = false;

    @Column(name = "sexe", length = 10)
    protected  String sexe;

    //@ManyToOne()
    //@JoinColumn(name="city_id",nullable = false)
    //protected TCity city;






    /*jointure unidirectionnelle de  la classe TUsers avec  la classe TMessages
   un utilisateur peut envoyer et ou recevoir un ou plusieurs messages*/
    @OneToMany(targetEntity = TMessages.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "user_fk",referencedColumnName = "id")
    private List<TMessages> messages;
}
