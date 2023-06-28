package simulador.redes_opticas.pon.service;

import org.springframework.stereotype.Service;
import simulador.redes_opticas.pon.model.Pon;

@Service
public class PonService {

    public Pon calculateValues(Pon pon) {
        double transPower = pon.getTransPower();
        double recvSensitivity = pon.getRecvSensitivity();
        double fiberAttenuation = pon.getFiberAttenuation();
        double connectorLoss = pon.getConnectorLoss();
        double splitterLoss = pon.getSplitterLoss();
        double maxDistance = pon.getMaxDistance();
        pon.setErro(false);

        if (Double.isNaN(transPower)) {
            // Cálculo da potência de transmissão
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da potência de transmissão
            transPower = maxDistance * attenuation + recvSensitivity + connectorLossDefault + splitterLossDefault;

        } else if (Double.isNaN(recvSensitivity)) {
            // Cálculo da sensibilidade de recepção
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da sensibilidade de recepção
            recvSensitivity = transPower - maxDistance * attenuation - connectorLossDefault - splitterLossDefault;

        } else if (Double.isNaN(fiberAttenuation)) {
            // Cálculo da atenuação por unidade de comprimento da fibra
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da atenuação por unidade de comprimento da fibra
            fiberAttenuation = (transPower - recvSensitivity - connectorLossDefault - splitterLossDefault) / maxDistance;

        } else if (Double.isNaN(connectorLoss)) {
            // Cálculo das perdas por conectores
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo das perdas por conectores
            connectorLoss = transPower - recvSensitivity - maxDistance * attenuation - splitterLossDefault;

        } else if (Double.isNaN(splitterLoss)) {
            // Cálculo das perdas por divisores de potência
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;

            // Cálculo das perdas por divisores de potência
            splitterLoss = transPower - recvSensitivity - maxDistance * attenuation - connectorLossDefault;


        } else if (Double.isNaN(maxDistance)) {
            // Cálculo da distância máxima do enlace entre OLT e ONU
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da distância máxima do enlace entre OLT e ONU
            maxDistance = (transPower - recvSensitivity - connectorLossDefault - splitterLossDefault) / attenuation;

        } 

        pon.setTransPower(transPower);
        pon.setRecvSensitivity(recvSensitivity);
        pon.setFiberAttenuation(fiberAttenuation);
        pon.setConnectorLoss(connectorLoss);
        pon.setSplitterLoss(splitterLoss);
        pon.setMaxDistance(maxDistance);

        return pon;
    }
}
