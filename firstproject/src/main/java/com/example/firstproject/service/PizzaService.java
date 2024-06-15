package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<PizzaDto> index() {
        return pizzaRepository.findAll().stream()
                .map(PizzaDto :: createPizzaDto)
                .collect(Collectors.toList());
    }

    public PizzaDto show(Long id) {
        return pizzaRepository.findById(id)
                .map(PizzaDto :: createPizzaDto)
                .orElseThrow(() -> new IllegalArgumentException("id 오류! 존재하지 않는 id입니다."));
    }

    @Transactional
    public PizzaDto create(PizzaDto dto) throws IllegalAccessException {
        // id값을 갖고 있을 경우 예외처리
        if (dto.getId() != null) {
            throw new IllegalAccessException("id 오류! id가 존재합니다.");
        }

        Pizza pizza = Pizza.createPizza(dto);

        Pizza created = pizzaRepository.save(pizza);

        return PizzaDto.createPizzaDto(created);
    }

    public PizzaDto update(Long id, PizzaDto dto) throws IllegalAccessException {
        // id가 존재하는지 확인
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id 오류! 존재하지 않는 id입니다."));

        target.patch(dto);

        Pizza updated = pizzaRepository.save(target);

        return PizzaDto.createPizzaDto(updated);
    }

    public PizzaDto delete(Long id) {
        // id가 존재하는지 확인
        Pizza deleted = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id 오류! 존재하지 않는 id입니다."));

        pizzaRepository.delete(deleted);

        return PizzaDto.createPizzaDto(deleted);
    }
}
