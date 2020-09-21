package exercicios_00g;

public class argumentoMain {
    public static void main(String[] args) {
        System.out.println("primeiro parametro:" + args[0]);
        System.out.println("numeros de parametros:" + args.length);
    }
}

//log do compilador

/*
*╭─iyan@iyan-Inspiron-5566 ~/PUC/AED2/unidade-0b 
╰─$ java argumentoMain algoritmos                                           1 ↵
primeiro parametro:algoritmos
numeros de parametros:1
╭─iyan@iyan-Inspiron-5566 ~/PUC/AED2/unidade-0b 
╰─$ java argumentoMain algoritmos e estruturas de dados II
primeiro parametro:algoritmos
numeros de parametros:6
*/