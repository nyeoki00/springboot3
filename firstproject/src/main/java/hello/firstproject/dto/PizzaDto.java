package hello.firstproject.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDto {
    private Long id;
    private String name;
    private int price;
}
