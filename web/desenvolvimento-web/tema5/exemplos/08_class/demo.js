const botao = document.querySelector("#comprar");
const card = document.querySelector("#card-produto");

botao.addEventListener("click", function () {
  card.classList.add("destaque");
});
