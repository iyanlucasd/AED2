
public class quest9 {

  private Fila filaMain;
  private Fila filaTmp;

  public quest9() {
    filaMain = new Fila();
    filaTmp = new Fila();
  }

  public void empilhar(int x) throws Exception {
    // quando a fila empilha, a pilha desempilha
    // sao operações simétricas opostas
    while (!(filaMain.primeiro == filaMain.ultimo)) {
      filaTmp.inserir(filaMain.remover());
    }

    filaMain.inserir(x);

    while (!(filaTmp.primeiro == filaTmp.ultimo)) {
      filaMain.inserir(filaTmp.remover());
    }
  }

  public int desempilhar() throws Exception {
    return filaMain.remover();
  }

  public void mostrar() {
    filaMain.mostrar();
  }
}
