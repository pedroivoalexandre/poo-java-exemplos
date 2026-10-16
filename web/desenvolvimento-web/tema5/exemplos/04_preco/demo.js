const preco = 3499;
const desconto = 500;
const precoFinal = preco - desconto;

const precoTela = document.querySelector("#preco");
precoTela.textContent = "R$ " + precoFinal;
