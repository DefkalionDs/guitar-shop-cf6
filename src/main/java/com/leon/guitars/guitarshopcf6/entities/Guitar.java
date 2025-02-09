package com.leon.guitars.guitarshopcf6.entities;


import com.leon.guitars.guitarshopcf6.dtos.GuitarDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "guitars")
public class Guitar {

    @Id
    @SequenceGenerator(
            name = "guitars_id_seq",
            sequenceName = "guitars_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guitars_id_seq"
    )
    private Long id;

    @Column
    private String name;

    @Column
    private Long fretNo;

    @Column
    private String shape;

    @Column
    private Double price;

    public Guitar(String name, Long fretNo, String shape, Double price) {
        this.name = name;
        this.fretNo = fretNo;
        this.shape = shape;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Guitar() {
        super();
    }

    public GuitarDTO asDTO() {
        return new GuitarDTO(this.id, this.name, this.fretNo, this.shape, this.price);
    }
}
