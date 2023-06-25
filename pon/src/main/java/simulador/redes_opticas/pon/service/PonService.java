package simulador.redes_opticas.pon.service;

import org.springframework.stereotype.Service;
import simulador.redes_opticas.pon.model.Pon;

@Service
public class PonService {

    public Pon calculateValues(Pon pon) {
        if (Double.isNaN(pon.getTransPower())) {
            // Cálculo da potência de transmissão com base nos outros valores fornecidos
            // Implemente a lógica de cálculo aqui
        } else if (Double.isNaN(pon.getRecvSensitivity())) {
            // Cálculo da sensibilidade de recepção com base nos outros valores fornecidos
            // Implemente a lógica de cálculo aqui
        } else if (Double.isNaN(pon.getFiberAttenuation())) {
            // Cálculo da atenuação por unidade de comprimento da fibra com base nos outros valores fornecidos
            // Implemente a lógica de cálculo aqui
        } else if (Double.isNaN(pon.getConnectorLoss())) {
            // Cálculo das perdas por conectores com base nos outros valores fornecidos
            // Implemente a lógica de cálculo aqui
        } else if (Double.isNaN(pon.getSplitterLoss())) {
            // Cálculo das perdas por divisores de potência com base nos outros valores fornecidos
            // Implemente a lógica de cálculo aqui
        } else if (Double.isNaN(pon.getMaxDistance())) {
            // Cálculo da distância máxima do enlace entre OLT e ONU com base nos outros valores fornecidos
            // Implemente a lógica de cálculo aqui
        }

        // Retorne os valores calculados ou atualizados no objeto Pon
        return pon;
    }
}
