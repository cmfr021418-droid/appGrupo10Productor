package pe.edu.cibertec.appgrupo10productor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.appgrupo10productor.rabbitmq.FibonacciProductor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    private final FibonacciProductor fibonacciProductor;

    @GetMapping("/send")
    public String enviarNumeros(@RequestParam String numbers){
        fibonacciProductor.enviarNumeros(numbers);
        return "Lista enviada a RabbitMQ correctamente";
    }
}
