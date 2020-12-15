class Hash {
   Jogador tabela[];
   int m;
   int NULO = -1;

   public Hash (){
      this(13);
   }

   public Hash (int m){
      this.m = m;
      this.tabela = new Jogador [this.m];
      for(int i = 0; i < m; i++){
         tabela[i] = null;
      }
   }

   public int h(int elemento){
      return elemento % m;
   }

   public int reh(int elemento){
      return ++elemento % m;
   }

   public boolean inserir (Jogador elemento){
      boolean resp = false;

      if(elemento != null){

         int pos = h(elemento.getAltura());

         if(tabela[pos] == null){
            tabela[pos] = elemento;
            resp = true;

         } else{

            pos = reh(elemento.getAltura());

            if(tabela[pos] == null){
               tabela[pos] = elemento;
               resp = true;
            }
         }
      }

      return resp;
   }

   public boolean pesquisar (String elemento, int altura){
      boolean resp = false;

      int pos = h(altura);

      if(tabela[pos].getNome().equals(elemento)){
         resp = true;

      } else {
         pos = reh(altura);

         if(tabela[pos].getNome().equals(elemento)){
            resp = true;
         }
      }
      return resp;
   }

   boolean remover (int elemento){
      boolean resp = false;

      //...

      return resp;
   }
}
