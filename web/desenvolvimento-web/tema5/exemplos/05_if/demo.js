const estoque = 3;
const status = document.querySelector("#status");

if (estoque > 0) {
  status.textContent = "Disponível para compra";
} else {
  status.textContent = "Produto indisponível";
}
