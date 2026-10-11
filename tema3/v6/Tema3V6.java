public class Tema3V6 {
    interface LimitaVelocidade {
        int getVelocidadeMaxima();
    }

    static class Segmento implements LimitaVelocidade {
        private int tamanho;

        public Segmento(int tamanho) {
            this.tamanho = tamanho;
        }

        @Override
        public int getVelocidadeMaxima() {
            return 80;
        }

        public int getTamanho() {
            return tamanho;
        }
    }
    static class Reta extends Segmento {
        public Reta(int tamanho) {
            super(tamanho);
        }

        @Override
        public int getVelocidadeMaxima() {
            return 100;
        }
    }
    static class CurvaTranquila extends Segmento {
        public CurvaTranquila(int tamanho) {
            super(tamanho);
        }

        @Override
        public int getVelocidadeMaxima() {
            return 60;
        }
    }
    static class CurvaMedia extends Segmento {
        public CurvaMedia(int tamanho) {
            super(tamanho);
        }

        @Override
        public int getVelocidadeMaxima() {
            return 40;
        }
    }
    static class CurvaForte extends Segmento {
        public CurvaForte(int tamanho) {
            super(tamanho);
        }

        @Override
        public int getVelocidadeMaxima() {
            return 30;
        }
    }
    static class QuebraMola extends Segmento {
        public QuebraMola(int tamanho) {
            super(tamanho);
        }

        @Override
        public int getVelocidadeMaxima() {
            return 20;
        }
    }
    @FunctionalInterface
    interface AvisoTrecho {
        String gerar(int limite);
    }

    static class Moto {
        private int velocidadeDesejada;

        public Moto(int velocidadeDesejada) {
            this.velocidadeDesejada = velocidadeDesejada;
        }

        public int getVelocidadeDesejada() {
            return velocidadeDesejada;
        }
    }

    static class Estrada {
        private LimitaVelocidade[] percurso;

        public Estrada(LimitaVelocidade[] percurso) {
            this.percurso = percurso;
        }

        public void percorrer(Moto moto) {
            for (int i = 0; i < percurso.length; i++) {
                int limite = percurso[i].getVelocidadeMaxima();
                int velocidade = moto.getVelocidadeDesejada();

                if (velocidade > limite) velocidade = limite;

                System.out.println("Trecho " + (i + 1)
                    + ": " + velocidade + " km/h");
            }
        }
    }

    public static void main(String[] args) {
        LimitaVelocidade[] percurso = {
            new Reta(500),
            new CurvaTranquila(120),
            new QuebraMola(10)
        };
        Moto moto = new Moto(90);
        Estrada estrada = new Estrada(percurso);
        estrada.percorrer(moto);
    }
}
