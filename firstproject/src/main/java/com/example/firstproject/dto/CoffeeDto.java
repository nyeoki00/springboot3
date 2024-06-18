package com.example.firstproject.dto;

import com.example.firstproject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoffeeDto {
    private Long id;
    private String name;
    private int price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
