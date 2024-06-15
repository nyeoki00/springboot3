package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String price;

    public void patch(Coffee coffee) {
        if (coffee.name != null) {
            this.name = coffee.name;
        }
        if (coffee.price != null) {
            this.price = coffee.price;
        }
    }
}
