package hello.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
    @GetMapping("/api/hello")
    public String Hello(){
        return "hello world!";
    }
}
