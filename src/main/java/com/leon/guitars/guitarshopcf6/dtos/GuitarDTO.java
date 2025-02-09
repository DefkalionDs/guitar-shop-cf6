package com.leon.guitars.guitarshopcf6.dtos;

import com.leon.guitars.guitarshopcf6.entities.Guitar;

public class GuitarDTO {

    private Long id;
    private String name;
    private Long fretNo;
    private String shape;
    private Double price;

    public GuitarDTO(Long id, String name, Long fretNo, String shape, Double price) {
        this.id = id;
        this.name = name;
        this.fretNo = fretNo;
        this.shape = shape;
        this.price = price;
    }

    public GuitarDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFretNo() {
        return fretNo;
    }

    public void setFretNo(Long fretNo) {
        this.fretNo = fretNo;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Guitar asEntity() {
        return new Guitar(this.name, this.fretNo, this.shape, this.price);
    }

}
