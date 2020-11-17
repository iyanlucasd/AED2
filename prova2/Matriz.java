class Matriz {
   int linha, coluna;
   Celula inicio;

   public void inserir(int x) {
      // System.out.println(x);
      for (Celula i = inicio; i != null; i = i.inf) {
         for (Celula j = i; j != null; j = j.dir) {
            j.elemento = x;
         }
      }

   }

   public Matriz(int linha, int coluna) {
      this.linha = linha;
      this.coluna = coluna;
      int x = 0;

      Celula i, j;
      int lin, col;

      // Criar a primeira celula
      inicio = new Celula(x++);

      // Criar as demais (coluna-1) celulas da 1a linha
      for (j = inicio, col = 1; col < coluna; j = j.dir, col++) {
         j.dir = new Celula(0);
         j.dir.esq = j;
      }

      // Criar as demais (linha-1) linhas
      for (i = inicio, lin = 1; lin < linha; i = i.inf, lin++) {
         i.inf = new Celula(0);
         i.inf.sup = i;

         for (j = i.inf, col = 1; col < coluna; j = j.dir, col++) {
            j.dir = new Celula(0);
            j.dir.esq = j;
            j.dir.sup = j.sup.dir;
            j.sup.dir.inf = j.dir;
         }
      }
   }

   public void mostrar() {
      for (Celula i = inicio; i != null; i = i.inf) {
         for (Celula j = i; j != null; j = j.dir) {
            System.out.print(j.elemento + " ");
         }
         System.out.println("");
      }
   }

   public void showDiagonalPrincipal() {
      if (this.linha == this.coluna && linha > 0) {
         Celula i = inicio;
         do {
            System.out.print(i.elemento + " ");
            i = i.dir;
            if (i != null) {
               i = i.inf;
            }
         } while (i != null);
      }
   }

   public void showDiagonalsecundaria() {
      if (this.linha == this.coluna && linha > 0) {
         Celula i;
         Celula temp = null;
         for (i = inicio; i != null; i = i.dir) {
            temp = i;
         }

         do {
            System.out.println(temp.elemento + " ");
            temp = temp.inf;

            if (temp != null) {
               temp = temp.esq;
            }

         } while (temp != null);
      }
   }

   public Matriz soma(Matriz a) {
      return soma(this, a);
   }

   public Matriz soma(Matriz a, Matriz b) {
      Matriz resp = null;

      if (a.linha == b.linha && a.coluna == b.coluna) {
         resp = new Matriz(a.linha, a.coluna);

         Celula iResp = resp.inicio;
         Celula iA = a.inicio;
         Celula iB = b.inicio;

         for (int i = 0; i < linha; i++) {
            Celula jResp = iResp;
            Celula jA = iA;
            Celula jB = iB;

            for (int j = 0; j < coluna; j++) {
               jResp.elemento = jA.elemento + jB.elemento;
               jResp = jResp.dir;
               jA = jA.dir;
               jB = jB.dir;
            }
            iResp = iResp.inf;
            iA = iA.inf;
            iB = iB.inf;
         }
      }
      return resp;
   }

   public Matriz multiplicacao(Matriz a, Matriz b) {
      Matriz resp = null;

      if (a.linha == b.coluna) {
         resp = new Matriz(a.linha, b.coluna);

         Celula iResp = resp.inicio;
         Celula iA = a.inicio;
         Celula iB = b.inicio;

         for (int i = 0; i < linha; i++) {
            Celula jResp = iResp;
            Celula jA = iA;
            Celula jB = iB;

            for (int k = 0; k < b.coluna; k++) {
               Celula tempA = jA;
               Celula tempB = jB;

               for (int j = 0; j < b.coluna; j++) {
                  jResp.elemento = jResp.elemento + (jA.elemento * jB.elemento);
                  jA = jA.dir;
                  jB = jB.inf;
               }
               jResp = jResp.dir;
               jA = tempA;
               jB = tempB.dir;
            }
            iResp = iResp.inf;
            iA = iA.inf;
         }
      }
      return resp;
   }

}