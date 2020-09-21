class ex3 extends Geracao {
    static int TAM = 33;

    public static void main(String[] args) {
        long[] tempo = new long[TAM];
        long[] movimentacao = new long[33];
        Selecao obj = new Selecao(100);
        Selecao obj2 = new Selecao(1000);
        Selecao obj3 = new Selecao(10000);

        for (int i = 0; i < 33; i++) {
            // obj.aleatorio();
            // obj.sort();
            obj2.aleatorio();
            obj2.sort();
            movimentacao[i] = obj2.novoSelecao();
            // obj3.aleatorio();
            // tempo[i] = obj3.now();
        }
        long soma = 0;
        for (int i = 0; i < tempo.length; i++) {
            soma = movimentacao[i] + soma;
        }
        soma = (soma / movimentacao.length);
        // System.out.println("primeiro = " + tempo[0]);
        // System.out.println("ultimo = " + tempo[32]);
        System.out.println("media = " + soma);
    }
}