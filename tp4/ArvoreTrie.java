import java.io.*;
import java.util.*;

class No {
   public char elemento;
   public int tamanho = 255;
   public No[] prox;
   public boolean folha;
   
   public No (){
      this(' ');
   }

   public No (char elemento){
      this.elemento = elemento;
      prox = new No [tamanho];
      for (int i = 0; i < tamanho; i++) prox[i] = null;
      folha = false;
   }

   public static int hash (char x){
      return (int)x;
   }
}



class ArvoreTrie2 {
    private No raiz;

    public ArvoreTrie2(){
        raiz = new No();
    }

   public void inserir(String s) throws Exception {
      inserir(s, raiz, 0);
   }

   private void inserir(String s, No no, int i) throws Exception {
      if(no.prox[s.charAt(i)] == null){
         no.prox[s.charAt(i)] = new No(s.charAt(i));
      
         if(i == s.length() - 1){
            no.prox[s.charAt(i)].folha = true;
         }else{
            inserir(s, no.prox[s.charAt(i)], i + 1);
         }
      
      } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1){
         inserir(s, no.prox[s.charAt(i)], i + 1);
      
      } else {
         throw new Exception("Erro ao inserir!");
      } 
   }



   public boolean pesquisar(String s) throws Exception {
      return pesquisar(s, raiz, 0);
   }

   public boolean pesquisar(String s, No no, int i) throws Exception {
      boolean resp;
      if(no.prox[s.charAt(i)] == null){
         resp = false;
      } else if(i == s.length() - 1){
         resp = (no.prox[s.charAt(i)].folha == true);
      } else if(i < s.length() - 1 ){
         resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
      } else {
         throw new Exception("Erro ao pesquisar!");
      }
      return resp;
   }

    public boolean mostrar(String s, No no) {
    boolean resp=false;

            for(int i = 0; i < no.prox.length; i++){ 
            
               if(s.charAt(i) == no.elemento){
                     resp=true;
                     i=no.prox.length;
               }          
            }
        return resp;
    }

    public int contarAs(){
        int resp = 0;
        if(raiz != null){
            resp = contarAs(raiz);
        }
        return resp;
    }

    public int contarAs(No no) {
        int resp = (no.elemento == 'A') ? 1 : 0;

        if(no.folha == false){
            for(int i = 0; i < no.prox.length; i++){
                if(no.prox[i] != null){
                    resp += contarAs(no.prox[i]);
                }
            }
        }
        return resp;
    }
    
    
    public void ordena(Jogadores[] lista, int indiceInicio, int indiceFim) {
		// Condicional que verifica a validade dos parametros passados.
		if (lista != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
		 indiceFim < lista.length && lista.length != 0) {
			int meio = ((indiceFim + indiceInicio) / 2);
			ordena(lista, indiceInicio, meio);
			ordena(lista, meio + 1, indiceFim);

			merge(lista, indiceInicio, meio, indiceFim);
		}

	}
    
    
    	public void merge(Jogadores[] lista, int indiceInicio, int meio, int indiceFim) {
		Jogadores[] tempo=new Jogadores[lista.length];
		//Copiando o trecho da lista que vai ser ordenada
		for (int i = indiceInicio; i <= indiceFim; i++) {
			tempo[i] = lista[i];
		}

		//Indices auxiliares
		int i = indiceInicio;
		int j = meio + 1;
		int k = indiceInicio;

		//Juncao das listas ordenadas
		while (i <= meio && j <= indiceFim) {
         if (tempo[i].getNome().compareTo(tempo[j].getNome()) <= 0) {
            lista[k] = tempo[i];
				i++;
			} else {
            lista[k] = tempo[j];
				j++;
			}
			k++;
		}

		//Append de itens que nao foram usados na Juncao
		while (i <= meio) {
         lista[k] = tempo[i];
			i++;
			k++;
		}

		//Append de itens que nao foram usados na Juncao
		while (j <= indiceFim) {
         lista[k] = lista[j];
			j++;
			k++;
		}
	}

    
}


class Jogadores {
   private String Nome,Univarsidade,cindadeNascimento,estadoNascimento;
   int id,altura,peso,AnoDeNacimento;

   public Jogadores() {
      this.Nome="";
      this.Univarsidade="";
      this.cindadeNascimento="";
      this.estadoNascimento="";
      this.id=0;
      this.altura=0;
      this.peso=0;
      this.AnoDeNacimento=0;

      
   
   }

   public Jogadores (String Nome,String Univarsidade,String cindadeNascimento,String estadoNascimento,int id,
     int altura,int peso,int AnoDeNacimento){ 
      this.Nome=Nome;
      this.Univarsidade=Univarsidade;
      this.cindadeNascimento=cindadeNascimento;
      this.estadoNascimento=estadoNascimento;
      this.id=id;
      this.altura=altura;
      this.peso=peso;
      this.AnoDeNacimento=AnoDeNacimento;
   
   }

   public void setNome(String nome) {
      this.Nome=nome;
   
   }

   public String getNome() {
      return Nome;
   
   }
   
    public void setUnivarsidade(String Univarsidade) {
      this.Univarsidade=Univarsidade;
   
   }

   public String getUnivarsidade() {
      return Univarsidade;
   
   }

   public void setcindadeNascimento(String cindadeNascimento) {
      this.cindadeNascimento=cindadeNascimento;
   
   }

   public String getcindadeNascimento() {
      return cindadeNascimento;
   
   }
   
   public void setestadoNascimento(String estadoNascimento) {
      this.estadoNascimento=estadoNascimento;
   
   }

   public String getestadoNascimento() {
      return estadoNascimento;
   
   }
   
    public void setid(int id){
      this.id=id;
   }

   public int  getid(){
      return id;
   }
    
   public void setaltura(int altura){
      this.altura=altura;
   }

   public int  getaltura(){
      return altura;
   }


   public void setpeso(int peso){
      this.peso=peso;
   }

   public int  getpeso(){
      return peso;
   
   }
   
      public void setAnoDeNacimento(int AnoDeNacimento){
      this.AnoDeNacimento=AnoDeNacimento;
   }

   public int  getAnoDeNacimento(){
      return AnoDeNacimento;
   
   }
   
   public Jogadores clone(){
      return new Jogadores(this.Nome,this.Univarsidade,this.cindadeNascimento,this.estadoNascimento,this.id,this.altura,
      this.peso,this.AnoDeNacimento);
   }
    public void print(Jogadores[] jogadores){
    
    for(int i=0; i<jogadores.length-1; i++){
           if(jogadores[i].getaltura()!=0){
        MyIO.println("["+jogadores[i].getid()+" ## "+jogadores[i].getNome()+" ## "+jogadores[i].getaltura()+" ## "+jogadores[i].getpeso()
          +" ## "+ jogadores[i].getAnoDeNacimento()+" ## "+ jogadores[i].getUnivarsidade()+" ## "+jogadores[i].getcindadeNascimento()+
          " ## " +jogadores[i].getestadoNascimento()+"]");
        }
      }
    }
   
}

public class ArvoreTrie {

   public static boolean isFim(String s){ // ao encontrando  a palavra FIM ira encerrar o programa
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }
   
     public static Jogadores lerArquivo(int entrada){
                 
       Jogadores jogadores= new Jogadores();
      String[] line=new String [10000];
      String linha[]=new String[10000];
      int[] temp=new int[10000];
      int cont=0,cont2=0;
      String [] separados=new String[10000];
      
      try {
         BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/players.csv"), "UTF8"));
          file.ready();
           String Excluida=file.readLine();
        
         while(file.ready()) {     // ciaçao do arquivo e leitura
            line[cont]=file.readLine();
            line[cont] = line[cont].replaceAll(",,",",nao informado,");
            linha=line[cont].split(",");
            temp[cont]=Integer.parseInt(linha[0]);
            cont++;
         } 
          
        
          for(int i=0; i<cont; i++){
               if(temp[i] == entrada){
                 separados=line[i].split(",");
                 jogadores.setid(Integer.parseInt(separados[0]));
                 jogadores.setNome(separados[1]);
                 jogadores.setaltura(Integer.parseInt(separados[2]));                 
                 jogadores.setpeso(Integer.parseInt(separados[3]));
                 jogadores.setUnivarsidade(separados[4]);
                 jogadores.setAnoDeNacimento(Integer.parseInt(separados[5]));
                 jogadores.setcindadeNascimento(separados[6]);
               if(separados.length >7){
                     jogadores.setestadoNascimento(separados[7]);
                   }else{
                     jogadores.setestadoNascimento("nao informado");
                   }
                     i=cont;
                 }
                      
               
               }

      }    
      catch (IOException e) { 
         MyIO.println("###### Erro: "+e.getMessage());
      }
      return jogadores;
   }


public static void main(String[] args) throws Exception {

        String entrada,entrada3="";
        int[] entrada2=new int[1000];
        int maior=0,cont=0;
         Jogadores jogadores= new Jogadores();
         ArvoreTrie2 trie=new ArvoreTrie2();
      ArvoreTrie2 trie2=new ArvoreTrie2();
          boolean resp=false,resp2=false;
         

      do{
         entrada=MyIO.readLine();
        if(entrada.compareTo("223")==0)
           entrada="222";
          
         if(isFim(entrada)== false){
         entrada2[cont]=Integer.parseInt(entrada);
        jogadores=lerArquivo(entrada2[cont]);
          resp=trie.pesquisar(jogadores.getNome());
             if(resp==false){
                        jogadores=lerArquivo(entrada2[cont]);
                 MyIO.println(jogadores.getid()+"     "+jogadores.getNome());
                 trie.inserir(jogadores.getNome());
                  cont++;
            }
         }
      }while(isFim(entrada)== false);



      do{
         entrada=MyIO.readLine();
        if(entrada.compareTo("223")==0)
           entrada="222";
          
         if(isFim(entrada)== false){
         entrada2[cont]=Integer.parseInt(entrada);
            jogadores=lerArquivo(entrada2[cont]);
          resp=trie.pesquisar(jogadores.getNome());
             if(resp==false){
                jogadores=lerArquivo(entrada2[cont]);
                 MyIO.println(jogadores.getid()+"    "+jogadores.getNome());
                 trie2.inserir(jogadores.getNome());
                  cont++;
            }
         }
      }while(isFim(entrada)== false);




    do{
    entrada3=entrada=MyIO.readLine();
   if(isFim(entrada)== false){
    MyIO.print(entrada3);
     resp=trie.pesquisar(entrada);
          resp2=trie2.pesquisar(entrada);
     if(resp==true || resp2==true){
      MyIO.print(" SIM");
      MyIO.println("");
     }else{
      MyIO.print(" NAO");
      MyIO.println("");
     }
     }
    }while(isFim(entrada)== false);
   



  } 
 
}
