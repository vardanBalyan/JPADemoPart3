package com.ttn.JPADemoPart3.entities;

import javax.persistence.*;
import java.util.Set;

/*
* for one to one :
* @OneToOne
   @JoinColumn(name = "authorId")
   private Author author;  getter and setter for author

* For many to many :
* @ManyToMany(mappedBy = "books")
   private Set<Author> author;
   *

* For One to many bidirectional
* @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
*
*  For one to many unidirectional:
* no annotations applied here and also we do not have object of author
* class as instance variable
*
* For one to many without additional table:
* same as unidirectional
*
* */

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
