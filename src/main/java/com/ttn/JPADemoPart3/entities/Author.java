package com.ttn.JPADemoPart3.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "author")  // tells who own the mapping
    private Set<Subjects> subjects;
}
