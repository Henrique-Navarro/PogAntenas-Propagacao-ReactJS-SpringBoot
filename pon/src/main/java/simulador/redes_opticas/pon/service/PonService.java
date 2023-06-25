package simulador.redes_opticas.pon.service;

import jakarta.validation.constraints.Null;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import simulador.redes_opticas.pon.model.Pon;

@Service
public class PonService {

    public Pon calculateValues(Pon pon) {
        Double transPower = pon.getTransPower();
        Double recvSensitivity = pon.getRecvSensitivity();
        Double fiberAttenuation = pon.getFiberAttenuation();
        Double connectorLoss = pon.getConnectorLoss();
        Double splitterLoss = pon.getSplitterLoss();
        Double maxDistance = pon.getMaxDistance();

        int qtd_faltantes = 0;

        if (transPower == null) {
            qtd_faltantes++;
            if (qtd_faltantes > 1) return null;
            // Cálculo da potência de transmissão
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da potência de transmissão
            transPower = maxDistance * attenuation + recvSensitivity + connectorLossDefault + splitterLossDefault;

        }
        if (recvSensitivity == null) {
            qtd_faltantes++;
            if (qtd_faltantes > 1) return null;
            // Cálculo da sensibilidade de recepção
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da sensibilidade de recepção
            recvSensitivity = transPower - maxDistance * attenuation - connectorLossDefault - splitterLossDefault;

        }
        if (fiberAttenuation == null) {
            qtd_faltantes++;
            if (qtd_faltantes > 1) return null;
            // Cálculo da atenuação por unidade de comprimento da fibra
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da atenuação por unidade de comprimento da fibra
            fiberAttenuation = (transPower - recvSensitivity - connectorLossDefault - splitterLossDefault) / maxDistance;

        }
        if (connectorLoss == null) {
            qtd_faltantes++;
            if (qtd_faltantes > 1) return null;
            // Cálculo das perdas por conectores
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo das perdas por conectores
            connectorLoss = transPower - recvSensitivity - maxDistance * attenuation - splitterLossDefault;

        }
        if (splitterLoss == null) {
            qtd_faltantes++;
            if (qtd_faltantes > 1) return null;
            // Cálculo das perdas por divisores de potência
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;

            // Cálculo das perdas por divisores de potência
            splitterLoss = transPower - recvSensitivity - maxDistance * attenuation - connectorLossDefault;
        }
        if (maxDistance == null) {
            qtd_faltantes++;
            if (qtd_faltantes > 1) return null;
            // Cálculo da distância máxima do enlace entre OLT e ONU
            double attenuation = fiberAttenuation != 0.0 ? fiberAttenuation : 0.2;
            double connectorLossDefault = connectorLoss != 0.0 ? connectorLoss : 0.1;
            double splitterLossDefault = splitterLoss != 0.0 ? splitterLoss : 0.5;

            // Cálculo da distância máxima do enlace entre OLT e ONU
            maxDistance = (transPower - recvSensitivity - connectorLossDefault - splitterLossDefault) / attenuation;
        }
        if (qtd_faltantes++ > 1) return null;

        pon.setTransPower(transPower);
        pon.setRecvSensitivity(recvSensitivity);
        pon.setFiberAttenuation(fiberAttenuation);
        pon.setConnectorLoss(connectorLoss);
        pon.setSplitterLoss(splitterLoss);
        pon.setMaxDistance(maxDistance);

        return pon;
    }
}
