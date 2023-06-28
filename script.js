document.getElementById("myForm").addEventListener("submit", function (event) {
  event.preventDefault(); // Impede o envio do formulário

  // Captura dos dados inseridos pelo usuário
  var transPower = parseFloat(document.getElementById("transPower").value);
  var recvSensitivity = parseFloat(
    document.getElementById("recvSensitivity").value
  );
  var fiberAttenuation = parseFloat(
    document.getElementById("fiberAttenuation").value
  );
  var connectorLoss = parseFloat(
    document.getElementById("connectorLoss").value
  );
  var splitterLoss = parseFloat(document.getElementById("splitterLoss").value);
  var maxDistance = parseFloat(document.getElementById("maxDistance").value);

  // Verificação de campos vazios e cálculo dos dados ausentes
  if (isNaN(transPower)) {
    // Cálculo da potência de transmissão
    var attenuation = fiberAttenuation || 0.2; // Valor padrão de atenuação por unidade de comprimento da fibra
    var connectorLossDefault = connectorLoss || 0.1; // Valor padrão de perdas por conectores
    var splitterLossDefault = splitterLoss || 0.5; // Valor padrão de perdas por divisores de potência

    // Cálculo da potência de transmissão
    transPower =
      maxDistance * attenuation +
      recvSensitivity +
      connectorLossDefault +
      splitterLossDefault;

    // Exibição do resultado calculado
    document.getElementById("transPower").value = transPower.toFixed(2);
  } else if (isNaN(recvSensitivity)) {
    // Cálculo da sensibilidade de recepção
    var attenuation = fiberAttenuation || 0.2; // Valor padrão de atenuação por unidade de comprimento da fibra
    var connectorLossDefault = connectorLoss || 0.1; // Valor padrão de perdas por conectores
    var splitterLossDefault = splitterLoss || 0.5; // Valor padrão de perdas por divisores de potência

    // Cálculo da sensibilidade de recepção
    recvSensitivity =
      transPower -
      maxDistance * attenuation -
      connectorLossDefault -
      splitterLossDefault;

    // Exibição do resultado calculado
    document.getElementById("recvSensitivity").value =
      recvSensitivity.toFixed(2);
  } else if (isNaN(fiberAttenuation)) {
    // Cálculo da atenuação por unidade de comprimento da fibra
    var connectorLossDefault = connectorLoss || 0.1; // Valor padrão de perdas por conectores
    var splitterLossDefault = splitterLoss || 0.5; // Valor padrão de perdas por divisores de potência

    // Cálculo da atenuação por unidade de comprimento da fibra
    fiberAttenuation =
      (transPower -
        recvSensitivity -
        connectorLossDefault -
        splitterLossDefault) /
      maxDistance;

    // Exibição do resultado calculado
    document.getElementById("fiberAttenuation").value =
      fiberAttenuation.toFixed(2);
  } else if (isNaN(connectorLoss)) {
    // Cálculo das perdas por conectores
    var attenuation = fiberAttenuation || 0.2; // Valor padrão de atenuação por unidade de comprimento da fibra
    var splitterLossDefault = splitterLoss || 0.5; // Valor padrão de perdas por divisores de potência

    // Cálculo das perdas por conectores
    connectorLoss =
      transPower -
      recvSensitivity -
      maxDistance * attenuation -
      splitterLossDefault;

    // Exibição do resultado calculado
    document.getElementById("connectorLoss").value = connectorLoss.toFixed(2);
  } else if (isNaN(splitterLoss)) {
    // Cálculo das perdas por divisores de potência
    var attenuation = fiberAttenuation || 0.2; // Valor padrão de atenuação por unidade de comprimento da fibra
    var connectorLossDefault = connectorLoss || 0.1; // Valor padrão de perdas por conectores

    // Cálculo das perdas por divisores de potência
    splitterLoss =
      transPower -
      recvSensitivity -
      maxDistance * attenuation -
      connectorLossDefault;

    // Exibição do resultado calculado
    document.getElementById("splitterLoss").value = splitterLoss.toFixed(2);
  } else if (isNaN(maxDistance)) {
    // Cálculo da distância máxima do enlace entre OLT e ONU
    var attenuation = fiberAttenuation || 0.2; // Valor padrão de atenuação por unidade de comprimento da fibra
    var connectorLossDefault = connectorLoss || 0.1; // Valor padrão de perdas por conectores
    var splitterLossDefault = splitterLoss || 0.5; // Valor padrão de perdas por divisores de potência

    // Cálculo da distância máxima do enlace entre OLT e ONU
    maxDistance =
      (transPower -
        recvSensitivity -
        connectorLossDefault -
        splitterLossDefault) /
      attenuation;

    // Exibição do resultado calculado
    document.getElementById("maxDistance").value = maxDistance.toFixed(2);
  }

  const dados = {
    transPower,
    recvSensitivity,
    fiberAttenuation,
    connectorLoss,
    splitterLoss,
    maxDistance,
  };
  fazer_requisicao(dados);
});

function fazer_requisicao(dados) {
  fetch("http://localhost:8080/", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(dados),
  })
    .then((resp) => resp.json())
    .catch((err) => {
      console.log(err);
    });
}
