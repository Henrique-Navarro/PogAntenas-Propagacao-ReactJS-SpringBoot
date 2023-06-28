import React, { useState } from 'react';
import './App.css'
import Topo from "./img/TOPOGRAFIA.png";


const App = () => {
  const [transPower, setTransPower] = useState('');
  const [recvSensitivity, setRecvSensitivity] = useState('');
  const [fiberAttenuation, setFiberAttenuation] = useState('');
  const [connectorLoss, setConnectorLoss] = useState('');
  const [splitterLoss, setSplitterLoss] = useState('');
  const [maxDistance, setMaxDistance] = useState('');


 
  const fazer_requisicao = async (e) => {
    e.preventDefault();
    const dados = {
      transPower,
      recvSensitivity,
      fiberAttenuation,
      connectorLoss,
      splitterLoss,
      maxDistance,
    };
  
    fetch("http://localhost:8080", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(dados),
    })
      .then((resp) => resp.json())
      .then((data) => {
        // Atualize seus dados com base na resposta recebida
        this.setTransPower({ dadosRecebidos: data });
        this.setRecvSensitivity({ dadosRecebidos: data });
        this.setFiberAttenuation({ dadosRecebidos: data });
        this.setConnectorLoss({ dadosRecebidos: data });
        this.setSplitterLoss({ dadosRecebidos: data });
        this.setMaxDistance({ dadosRecebidos: data });
        console.log(data);
      })
      .catch((err) => {
        console.log(err);
      });
  };
  

  return (
    <div>
      <h1>Simulador de Redes Ópticas PON</h1>
<div className='topo'>
<img
            src={Topo}
            alt="imagem da Topografia"
            title="Topografia"
          />
</div>
      
    
      <form onSubmit={fazer_requisicao}>
        <label htmlFor="transPower">Potência de Transmissão:</label>
        <input
          type="number"
          id="transPower"
          name="transPower"
          step="any"
          value={transPower}
          onChange={(e) => setTransPower(e.target.value)}
        /><br /><br />

        <label htmlFor="recvSensitivity">Sensibilidade de Recepção:</label>
        <input
          type="number"
          id="recvSensitivity"
          name="recvSensitivity"
          step="any"
          value={recvSensitivity}
          onChange={(e) => setRecvSensitivity(e.target.value)}
        /><br /><br />

        <label htmlFor="fiberAttenuation">Atenuação por Unidade de Comprimento da Fibra:</label>
        <input
          type="number"
          id="fiberAttenuation"
          name="fiberAttenuation"
          step="any"
          value={fiberAttenuation}
          onChange={(e) => setFiberAttenuation(e.target.value)}
        /><br /><br />

        <label htmlFor="connectorLoss">Perdas por Conectores:</label>
        <input
          type="number"
          id="connectorLoss"
          name="connectorLoss"
          step="any"
          value={connectorLoss}
          onChange={(e) => setConnectorLoss(e.target.value)}
        /><br /><br />

        <label htmlFor="splitterLoss">Perdas por Divisores de Potência:</label>
        <input
          type="number"
          id="splitterLoss"
          name="splitterLoss"
          step="any"
          value={splitterLoss}
          onChange={(e) => setSplitterLoss(e.target.value)}
        /><br /><br />

        <label htmlFor="maxDistance">Distância Máxima do Enlace entre OLT e ONU:</label>
        <input
          type="number"
          id="maxDistance"
          name="maxDistance"
          step="any"
          value={maxDistance}
          onChange={(e) => setMaxDistance(e.target.value)}
        /><br /><br />

        <div id="btn_div">
          <input type="submit" value="Calcular" id="btn" />
        </div>
      </form>
    </div>
  );
};

export default App;
