package simulador.redes_opticas.pon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PonController {
    
    @GetMapping
    public ResponseEntity<String> calcular(){
        return ResponseEntity.status(HttpStatus.OK).body("Simulador de Redes Ópticas PON\n");
    }
}
