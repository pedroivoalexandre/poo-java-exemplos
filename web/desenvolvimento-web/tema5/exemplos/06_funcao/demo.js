const status = document.querySelector("#status");
const estoque = 3;

function atualizarStatus() {
  if (estoque > 0) {
    status.textContent = "Disponível para compra";
  } else {
    status.textContent = "Produto indisponível";
  }
}

atualizarStatus();
