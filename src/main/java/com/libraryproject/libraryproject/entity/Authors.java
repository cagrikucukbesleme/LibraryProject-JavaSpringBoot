package com.libraryproject.libraryproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Authors implements Serializable {
    @Id
    @SequenceGenerator(name="author_seq_gen",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_seq_gen")
    @Column(name = "ID")
    private Long id;
    @Column(name = "firstname",length = 100)
    private String firstname;
    @Column(name = "lastname",length = 100)
    private String lastname;


    @OneToMany
    @JoinColumn(name = "author_book_id")
    private List<Books> books;
}
