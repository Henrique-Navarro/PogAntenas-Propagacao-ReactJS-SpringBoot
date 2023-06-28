package simulador.redes_opticas.pon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Pon {
    private double transPower;
    private double recvSensitivity;
    private double fiberAttenuation;
    private double connectorLoss;
    private double splitterLoss;
    private double maxDistance;
    private boolean erro;
}
