const botao = document.querySelector("#comprar");
const mensagem = document.querySelector("#mensagem");

botao.addEventListener("click", function () {
  mensagem.textContent = "Produto adicionado!";
});
