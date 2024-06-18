package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;


    public void patch(Coffee coffee) {
        if (coffee.name != null) {
            this.name = coffee.name;
        }

        Optional<Integer> i = Optional.of(coffee.price);
        if (i != null) {
            this.price = coffee.price;
        }
    }
}
