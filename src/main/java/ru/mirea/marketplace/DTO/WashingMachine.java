package ru.mirea.marketplace.DTO;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "washing_machine")
public class WashingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "producer")
    private String producer;

    @Column(name = "tank_volume")
    private int tankVolume;

    @Column(name = "title")
    private String title;

    @Column(name = "seller_id")
    private int sellerId;

    @Column(name = "product_type")
    private int productType;

    @Column(name = "price")
    private int price;
}
