package com.libraryproject.libraryproject.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    //nesneyi diske yazma okuma yapabiliyoruz.
    //yapılan işlem tarihi ve yapanı göstermek için yazdık
    private Date createdDate;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

}
