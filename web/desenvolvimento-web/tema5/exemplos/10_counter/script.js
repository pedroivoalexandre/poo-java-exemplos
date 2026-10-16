let quantidade = 0;
const botao = document.querySelector("#comprar");
const carrinho = document.querySelector("#carrinho");
const mensagem = document.querySelector("#mensagem");

botao.addEventListener("click", function () {
  quantidade++;
  carrinho.textContent = "Itens no carrinho: " + quantidade;

  if (quantidade >= 3) {
    mensagem.textContent = "Limite de 3 itens atingido";
  }
});
