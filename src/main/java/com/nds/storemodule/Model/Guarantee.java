package com.nds.storemodule.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "guarantees")
public class Guarantee implements Serializable {


    private Integer guaranteeId;
    private String guaranteeName;
    private String description;

    public Guarantee() {
        super();
    }

    public Guarantee(Integer guaranteeId, String guaranteeName, String description) {
        this.guaranteeId = guaranteeId;
        this.guaranteeName = guaranteeName;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guarantee_id",nullable = false)
    public Integer getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Integer guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    @Column(name = "guarantee_name",nullable = false,length = 50)
    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    @Column(name = "description",length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
