package com.fda.inv.domain;

import javax.persistence.*;

@Entity
@Table(name = "typedevice")
public class TypeDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public TypeDevice(String name) {
        this.name = name;
    }

    protected TypeDevice() {

    }

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
