package com.example.firstproject.entity;

import com.example.firstproject.dto.PizzaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public static Pizza createPizza(PizzaDto dto) {
        return new Pizza(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }

    public void patch(PizzaDto dto) throws IllegalAccessException {
        if (this.id != dto.getId()) {
            throw new IllegalAccessException("id 오류! id가 일치하지 않습니다.");
        }

        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
    }
}
