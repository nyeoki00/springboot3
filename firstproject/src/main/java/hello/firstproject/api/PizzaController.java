package hello.firstproject.api;

import hello.firstproject.dto.PizzaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PizzaController {

    //피자 목록 조회
    @GetMapping("/pizzas")
    public ResponseEntity<PizzaDto> pizzas(){
        return null;
    }
    //피자 단일 조회
    @GetMapping("/pizzas/{pizzaId}")
    public ResponseEntity<PizzaDto> findOne(@PathVariable Long pizzaId){
        return null;
    }

    //피자 생성
    @PostMapping("/pizzas/{pizzaId}")
    public ResponseEntity<PizzaDto> create(@PathVariable Long pizzaId,
                                           RequestBody PizzaDto){
        return null;
    }

    @PatchMapping("/pizzas/{pizzaId}")
    public ResponseEntity<PizzaDto> patch(@PathVariable Long pizzaId,
                                           RequestBody PizzaDto){
        return null;
    }

    @DeleteMapping("/pizzas/{pizzaId}")
    public ResponseEntity<PizzaDto> delete(@PathVariable Long pizzaId){
        return null;
    }
}
