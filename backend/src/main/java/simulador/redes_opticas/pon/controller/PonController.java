package simulador.redes_opticas.pon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simulador.redes_opticas.pon.model.Pon;
import simulador.redes_opticas.pon.service.PonService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
public class PonController {
    
    @Autowired
    private PonService ponService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @PostMapping
    public ResponseEntity<String> calcular(@RequestBody Pon pon){
        try {
            Pon responseData = ponService.calculateValues(pon);
            String jsonResponse = objectMapper.writeValueAsString(responseData);
            return ResponseEntity.ok(jsonResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
