package com.libraryproject.libraryproject.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "adress")
    private String adress;
    @Enumerated
    private AdressType adressType;


    @Column(name = "isUserActive")
    private Boolean isUserActive;



    @ManyToOne
    @JoinColumn(name = "user_acoount_id")
    private User user;

    public enum AdressType{
        HOME_ADRESS,
        JOB_ADRESS,
        OTHER
    }



}
