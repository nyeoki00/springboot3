package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee show(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee create(CoffeeDto dto) {
        Coffee coffee = dto.toEntity();

        return coffeeRepository.save(coffee);
    }

    public Coffee update(Long id, CoffeeDto dto) {
        Coffee coffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);
        log.info("coffee: {}, target: {}", coffee, target);

        if (target == null || id != coffee.getId()) {
            log.info("잘못된 요청! id: {}, target: {}, coffee: {}", id, target, coffee);
            return null;
        }

        target.patch(coffee);
        return coffeeRepository.save(target);
    }

    public Coffee delete(Long id) {
        Coffee coffee = coffeeRepository.findById(id).orElse(null);

        if (coffee == null) {
            log.info("잘못된 요청!! id: {}, coffee: {}", id, coffee);
            return null;
        }

        coffeeRepository.delete(coffee);
        return coffee;
    }

    @Transactional
    public List<Coffee> createCoffees(List<CoffeeDto> dtos) {
        List<Coffee> coffeeList = dtos.stream()
                                      .map(CoffeeDto :: toEntity)
                                      .collect(Collectors.toList());

        coffeeList.forEach(coffeeRepository :: save);

        coffeeRepository.findById(-1L)
                        .orElseThrow(() -> new IllegalArgumentException("결제 실패!"));

        return coffeeList;
    }
}
