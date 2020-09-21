package exercicios_00l;

import java.util.*;

import java.io.*;

class retangulo {
    // variáveis privadas
    private double base = 0;
    private double altura = 0;

    // construtor
    public retangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public retangulo(double a, double b) {
        this.base = b;
        this.altura = a;
    }

    // setter e getters
    public void setBase(double b) {
        this.base = b;
    }

    public void setAltura(double a) {
        this.altura = a;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    // leitor do teclado
    public void leitor() {
        Scanner input = new Scanner(System.in);
        setBase(input.nextDouble());
        setAltura(input.nextDouble());
    }

    // print dos dados
    public void escreveAll() {
        System.out.println("base = " + getBase());
        System.out.println("altura = " + getAltura());
        System.out.println("perimetro = " + getPerimetro());
        System.out.println("area = " + getArea());
        System.out.println("diagonal = " + getDiagonal());

    }

    // exercício 1
    public double getArea() {
        double area = 0;
        double b = getBase();
        double a = getAltura();
        area = a * b;
        return area;
    }

    // exercício 2
    public double getPerimetro() {
        double perimetro = 0;
        double b = getBase();
        double a = getAltura();
        perimetro = 2 * (a + b);
        return perimetro;
    }

    // exercício 3
    public double getDiagonal() {
        double diagonal = 0;
        double b = getBase();
        double a = getAltura();
        double aux = Math.pow(a, 2) + Math.pow(b, 2);
        diagonal = Math.sqrt(aux);
        return diagonal;
    }

} // fim classe retângulo

// classe lixão
// exercício 4
public class classeRetangulo {
    public static void main(String[] args) {
        retangulo ret1 = new retangulo();
        retangulo ret2 = new retangulo();
        // o método escreveALl() já chama todos os outros métodos automaticamente
        ret1.leitor();
        ret1.escreveAll();
        ret2.leitor();
        ret2.escreveAll();

    }
}