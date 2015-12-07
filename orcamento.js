var nome;
var email;
var telefone;
var cidade;
var moradores
var arCondicionado = [1200, 0];
var comodos        = [10,0];
var geladeira      = [200, 0];
var computador     = [300, 0];
var chuveiro       = [4400, 0];
var televisao      = [200, 0];
var microondas     = [1200,0];

var energiaTotal = 0;
//  energiaTotal =  potencia do aparelho * horas * quantidade informada pelo usuario
function orcamento() {
  //recebe formulario
  nome = $('#nome').value();
  alert(nome);
  /*
  email     = document.formularioOrcamento.email.value();
  telefone  = document.formularioOrcamento.telefone.value();
  cidade    = document.formularioOrcamento.cidade.value();
  moradores = document.formularioOrcamento.moradores.value();

  arCondicionado[1] = document.formularioOrcamento.arCondicionados.value();
  comodos[1]        = document.formularioOrcamento.comodos.value();
  geladeiras[1]     = document.formularioOrcamento.geladeiras.value();
  computadores[1]   = document.formularioOrcamento.computadores.value();
  televisao[1]      = document.formularioOrcamento.tv.value();
  microondas[1]     = document.formularioOrcamento.microondas.value();
  */
  energiaTotal += ((arCondicionado[0] * 6   ) * arCondicionado[1]);
  energiaTotal += ((comodos[0]        * 6   ) * comodos[1]);
  energiaTotal += ((geladeira[0]      * 12  ) * geladeira[1]);
  energiaTotal += ((computador[0]     * 6   ) * computador[1]);
  energiaTotal += ((chuveiro[0]       * 0.17) * chuveiro[1]);
  energiaTotal += ((televisao[0]      * 6   ) * televisao[1]);
  energiaTotal += ((microondas[0]     * (moradores * 0.08)) * microondas[1]);

  document.getElementById('formulario_campo_resultado').innerHTML = "O resultado é: " + energiaTotal;
}

//
