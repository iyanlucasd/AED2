class ex2 extends Geracao {

    public static void main(String[] args) {
        Selecao obj = new Selecao(100);
        obj.aleatorio();
        obj.sort();
        Selecao obj2 = new Selecao(100);
        obj2.aleatorio();
        obj2.novoSelecao();
    }
}

/**
 * o código é mais econômico em relação à movimentações, pelo fato de que, o
 * original, faz a troca do mesmo número mesmo que i seja igual a menor. Com a
 * adição do if(i != menor), toda vez que o menor seja igual a i, ele pula a
 * movimentação.
 * Iyan Lucas
 */