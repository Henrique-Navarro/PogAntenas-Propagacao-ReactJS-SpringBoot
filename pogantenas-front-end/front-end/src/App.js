import React, { useState } from 'react';
import './App.css'
import Topo from "./img/TOPOGRAFIA.png";
import 'react-image-lightbox/style.css';
const App = () => {
  const [transPower, setTransPower] = useState('');
  const [recvSensitivity, setRecvSensitivity] = useState('');
  const [fiberAttenuation, setFiberAttenuation] = useState('');
  const [connectorLoss, setConnectorLoss] = useState('');
  const [splitterLoss, setSplitterLoss] = useState('');
  const [maxDistance, setMaxDistance] = useState('');

  const handleSubmit = (event) => {
    }
  

  const [isOpen, setIsOpen] = useState(false);

  const handleImageClick = () => {
    setIsOpen(true);
  };

  const handleClose = () => {
    setIsOpen(false);
  }
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
      
    
      <form onSubmit={handleSubmit}>
        <label htmlFor="transPower">Potência de Transmissão:</label>
        <input
          type="number"
          id="transPower"
          name="transPower"
          step="any"
          value={transPower}
          onChange={(event) => setTransPower(event.target.value)}
        /><br /><br />

        <label htmlFor="recvSensitivity">Sensibilidade de Recepção:</label>
        <input
          type="number"
          id="recvSensitivity"
          name="recvSensitivity"
          step="any"
          value={recvSensitivity}
          onChange={(event) => setRecvSensitivity(event.target.value)}
        /><br /><br />

        <label htmlFor="fiberAttenuation">Atenuação por Unidade de Comprimento da Fibra:</label>
        <input
          type="number"
          id="fiberAttenuation"
          name="fiberAttenuation"
          step="any"
          value={fiberAttenuation}
          onChange={(event) => setFiberAttenuation(event.target.value)}
        /><br /><br />

        <label htmlFor="connectorLoss">Perdas por Conectores:</label>
        <input
          type="number"
          id="connectorLoss"
          name="connectorLoss"
          step="any"
          value={connectorLoss}
          onChange={(event) => setConnectorLoss(event.target.value)}
        /><br /><br />

        <label htmlFor="splitterLoss">Perdas por Divisores de Potência:</label>
        <input
          type="number"
          id="splitterLoss"
          name="splitterLoss"
          step="any"
          value={splitterLoss}
          onChange={(event) => setSplitterLoss(event.target.value)}
        /><br /><br />

        <label htmlFor="maxDistance">Distância Máxima do Enlace entre OLT e ONU:</label>
        <input
          type="number"
          id="maxDistance"
          name="maxDistance"
          step="any"
          value={maxDistance}
          onChange={(event) => setMaxDistance(event.target.value)}
        /><br /><br />

        <div id="btn_div">
          <input type="submit" value="Calcular" id="btn" />
        </div>
      </form>
    </div>
  );
};

export default App;
