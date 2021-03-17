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
* */

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
