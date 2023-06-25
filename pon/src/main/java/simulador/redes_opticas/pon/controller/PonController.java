package simulador.redes_opticas.pon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    public ResponseEntity<Pon> calcular(@RequestBody Pon pon) throws JsonProcessingException {
        Pon responseData = ponService.calculateValues(pon);

        if (responseData == null) return new ResponseEntity<Pon>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Pon>(responseData, HttpStatus.OK);
    }
}
