class PercursoInvalidoException extends Exception {
    PercursoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
class Estrada {
    private int metros;
    Estrada(int metros) throws PercursoInvalidoException {
        if (metros <= 0) {
            throw new PercursoInvalidoException("Percurso sem tamanho");
        }
        this.metros = metros;
    }
    int getMetros() {
        return metros;
    }
}
public class Tema4V4 {
    public static void main(String[] args) {
        try {
            Estrada estrada = new Estrada(0);
            System.out.println(estrada.getMetros());
        } catch (PercursoInvalidoException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
