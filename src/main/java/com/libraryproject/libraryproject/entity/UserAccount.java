package com.libraryproject.libraryproject.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//veri tabanı entity olacak
@Entity
@Table(name="user_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class UserAccount implements Serializable {

    @Id
    @SequenceGenerator(name="acoount_seq_gen",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "acoount_seq_gen")
    private Long id;

    @Column(name = "userbooks")
    private String userBooks;

    @Enumerated(EnumType.STRING)
    @Column(name = "booktype",length = 30)
    private BookType bookType;


    @Column(name = "isuseractive")
    private Boolean isUserActive;



    @ManyToOne
    @JoinColumn(name = "user_acoount_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "acoount_book_id")
    private List<Books> books;

    public enum BookType{

        NOVEL("Novel"),
        MYTH("Myth"),
        HISTORY("History"),
        POEMS("Poems"),
        DRAMA("Drama"),
        BIOGRAPHY("Biography");

        private final  String bookType;

        BookType(String bookType) {
            this.bookType = bookType;
        }
    }



}
