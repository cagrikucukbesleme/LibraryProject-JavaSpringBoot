package com.libraryproject.libraryproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
public class Books implements Serializable {
    @Id
    @SequenceGenerator(name="book_seq_gen",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_seq_gen")
    @Column(name = "ID")
    private Long id;
    @Column(name = "book_name",length = 100)
    private String bookName;
    @Column(name = "isBookActive")
    private Boolean isBookActive;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "bookstype",length = 30)
    private Books.BooksType booksType;


    @ManyToOne
    @JoinColumn(name = "acoount_book_id")
    private UserAccount userAccounts;

    @ManyToOne
    @JoinColumn(name = "author_book_id")
    private Authors authors_id;



    public enum BooksType{

        NOVEL("Novel"),
        MYTH("Myth"),
        HISTORY("History"),
        POEMS("Poems"),
        DRAMA("Drama"),
        BIOGRAPHY("Biography");

        private String booksType ;

        BooksType(String bookType) {
            this.booksType = booksType;
        }
    }


}
