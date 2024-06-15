package hello.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int price;
}
