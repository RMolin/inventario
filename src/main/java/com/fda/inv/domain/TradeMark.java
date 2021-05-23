package com.fda.inv.domain;

import javax.persistence.*;

@Entity
@Table(name = "trademark")
public class TradeMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public TradeMark(String name) {
        this.name = name;
    }

    protected TradeMark() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
