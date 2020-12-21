import java.io.*;
import java.util.*;


public class Ciframento_java {


    public static String codificador(String s,String aux,int cont) throws Exception { 
        
         if(cont == s.length() ) { 
             return aux; 
            }//end for 
             aux += (char)(s.charAt(cont)+3);
            
             return codificador(s,aux,cont+1);
            
    }//end codificador

    public static void main (String[] args) throws Exception{ 
         
        Scanner input = new Scanner(System.in);
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
        String[] entrada = new String[1000];
        int numEntrada = 0;
        String aux = "";
        
        entrada[numEntrada] = MyIO.readLine();
        while(entrada[numEntrada].equals("FIM") != true ){          
            
            MyIO.println(codificador(entrada[numEntrada],aux,0)); 
            
            numEntrada++;
            entrada[numEntrada] = MyIO.readLine();
        }//end while
                    
    }//end main 
}//end Class Ciframento
