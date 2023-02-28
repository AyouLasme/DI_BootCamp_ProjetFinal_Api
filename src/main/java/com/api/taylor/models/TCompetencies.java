package com.api.taylor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competencies")

public class TCompetencies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name ="title", length = 60)
    private String title;

    @Column(name ="description", columnDefinition = "text")
    private String description;


    /*jointure unidirectionnelle de  la classe TCompetences avec  la classe TImages
    Dans une competence on peut avoir une ou plusieurs images*/
    @OneToMany(targetEntity = TImages.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "competencies_fk",referencedColumnName = "id")
    private List<TImages> images;


    /*jointure bidirectionnelle de  la classe TTaylors avec  la classe TCompetencies
       un tailleur peut avoir une ou plusieurs competences et une competences peut appartenir
         à un ou plusieurs tailleurs */
    @ManyToMany(mappedBy = "competencies")
    private Set<TTaylors> taylors = new HashSet<>();


}
