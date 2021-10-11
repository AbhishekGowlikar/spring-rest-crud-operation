package com.abhishek.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SITES")
public class Site implements Serializable {

    @Id
    private int siteId;
    private String siteName;
    private String siteOwner;

}
