package com.libraryproject.libraryproject.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kullanici")
@Data
//veri tabaına erişilen katman. Dışarıya kapalı olan kısım
//data anotation ile tüm setter, getter ve toString metodları otomatik oluşturur
public class User {
    @Id
    @SequenceGenerator(name="user_seq_gen",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @Column(name = "ID")
    private Long id;
    @Column(name = "firstname",length = 100)
    private String firstname;
    @Column(name = "lastname",length = 100)
    private String lastname;

    @OneToMany
    @JoinColumn(name = "user_acoount_id")
    private List<UserAccount> userAccounts;
}
