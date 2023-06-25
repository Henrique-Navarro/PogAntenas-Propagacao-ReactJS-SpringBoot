package simulador.redes_opticas.pon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Pon {
    private Double transPower;
    private Double recvSensitivity;
    private Double fiberAttenuation;
    private Double connectorLoss;
    private Double splitterLoss;
    private Double maxDistance;
}
