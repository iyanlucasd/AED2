public class Hash {
   Jogador tabela[];
   int m1, m2, m, reserva;
   int NULO = -1;

   public Hash() {
      this(13, 7);
   }

   public Hash(int m1, int m2) {
      this.m1 = m1;
      this.m2 = m2;
      this.m = m1 + m2;
      this.tabela = new Jogador[this.m];
      for (int i = 0; i < m; i++) {
         tabela[i] = null;
      }
      reserva = 0;
   }

   public int h(int elemento) {
      return elemento % m1;
   }

   public boolean inserir(Jogador elemento) {
      boolean resp = false;

      if (elemento != null) {
         int pos = h(elemento.getAltura());
         if (tabela[pos] == null) {
            tabela[pos] = elemento;
            resp = true;
         } else if (reserva < m2) {
            tabela[m1 + reserva] = elemento;
            reserva++;
            resp = true;
         }
      }

      return resp;
   }

   public boolean pesquisar(String elemento, int altura) {
      boolean resp = false;

      int pos = h(altura);
      if (tabela[pos].getNome().equals(elemento)) {
         // System.out.println("chegou");
         resp = true;

      } else {
         for (int i = 0; i < reserva; i++) {
            if (tabela[m1 + i].getNome().equals(elemento)) {
               resp = true;
               i = reserva;
            }
         }
         // System.out.println("---------------------");
         // System.out.println(tabela[pos].getNome());
         // System.out.println(elemento);
         // System.out.println("---------------------");
      }
      return resp;
   }

   boolean remover(int elemento) {
      boolean resp = false;

      // ...

      return resp;
   }
}
