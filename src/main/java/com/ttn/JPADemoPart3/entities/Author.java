package com.ttn.JPADemoPart3.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
* for one to one :
* @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
    private Books books; getter and setter for books

* For many to many :
*  @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authors_book",
    joinColumns = @JoinColumn(name = "authorId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "bookId", referencedColumnName = "id"))
    private Set<Books> books;
    *

* For One to many bidirectional:
* @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Books> books;
    *

* For one to many unidirectional:
*  @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private Set<Books> books;
    *

* For one to many without additional table:
* same as unidirectional
*/

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)  // tells who own the mapping
    private Set<Subjects> subjects;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private Set<Books> books;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }

    public void addSubjects(Subjects subject)
    {
        if(subject != null)
        {
            if(subjects == null)
            {
                subjects = new HashSet<>();
            }
            subject.setAuthor(this);
            subjects.add(subject);
        }
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    public void addBooks(Books book)
    {
        if(book != null)
        {
            if(books == null)
            {
                books = new HashSet<>();
            }
            books.add(book);
        }
    }
}
