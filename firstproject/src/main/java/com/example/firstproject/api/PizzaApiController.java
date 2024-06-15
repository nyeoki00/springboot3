package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/api/pizzas")
    public ResponseEntity<List<PizzaDto>> index() {
        List<PizzaDto> dtos = pizzaService.index();

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("api/pizzas/{id}")
    public ResponseEntity<PizzaDto> show(@PathVariable Long id) {
        PizzaDto dto = pizzaService.show(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("api/pizzas")
    public ResponseEntity<PizzaDto> create(@RequestBody PizzaDto dto) throws IllegalAccessException {
        PizzaDto created = pizzaService.create(dto);

        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @PatchMapping("api/pizzas/{id}")
    public ResponseEntity<PizzaDto> update(@PathVariable Long id, @RequestBody PizzaDto dto) throws IllegalAccessException {
        PizzaDto updated = pizzaService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("api/pizzas/{id}")
    public ResponseEntity<PizzaDto> delete(@PathVariable Long id) {
        PizzaDto deleted = pizzaService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
