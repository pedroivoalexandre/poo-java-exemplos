class PercursoInvalidoException extends Exception {
    PercursoInvalidoException(String mensagem) { super(mensagem); }
}
class Estrada {
    static void validar(int tamanho) throws PercursoInvalidoException {
        if (tamanho <= 0) {
            throw new PercursoInvalidoException("Trecho sem tamanho");
        }
    }
}
public class Tema4V4 {
    public static void main(String[] args) {
        try {
            Estrada.validar(0);
        } catch (PercursoInvalidoException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
