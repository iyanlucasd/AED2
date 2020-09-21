package exercicios_00l;

import java.util.*;
import java.io.*;

class Ponto {
    // variáveis privadas
    private double x = 0;
    private double y = 0;
    private int id;
    static private int nextId = 0;

    // construtor vazio
    public Ponto() {
        this.x = 0;
        this.y = 0;
        this.id = nextId;
        nextId++;
    }

    // construtor com parâmetro
    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
        this.id = nextId;
        nextId++;
    }

    // setters e getters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getID() {
        return id;
    }

    public static int getNextID() {
        return nextId;
    }

    // leitor para o construtor vazio
    public void leitor() {
        Scanner input = new Scanner(System.in);
        setX(input.nextDouble());
        setY(input.nextDouble());
    }

    public double dist(Ponto p2) {
        double distancia = 0;
        double auxiliar = 0;
        auxiliar = Math.pow((getX() - p2.getX()), 2) + Math.pow((getY() - p2.getY()), 2);
        distancia = Math.sqrt(auxiliar);
        return distancia;
    }

    public double dist(double x, double y) {
        double distancia = 0;
        double auxiliar = 0;
        auxiliar = Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2);
        distancia = Math.sqrt(auxiliar);
        return distancia;
    }

    public static double dist(double x1, double x2, double y1, double y2) {
        double distancia = 0;
        double auxiliar = 0;
        auxiliar = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
        distancia = Math.sqrt(auxiliar);
        return distancia;
    }

    public static boolean isTriangulo(Ponto p1, Ponto p2, Ponto p3) {
        boolean resultado = true;
        if (p1.dist(p2) + p2.dist(p3) == p3.dist(p1)) {
            resultado = false;
        }

        return resultado;
    }
    public double getAreaRetangulo(Ponto p2) {
        double resultado = 0;
        double distancia1 = getX() + getY();
        double distancia2 = p2.getX() + p2.getY();
        resultado = distancia1 * distancia2;
        return resultado;
    }

}

public class classePonto {
    public static void main(String[] args) {
        Ponto p1 = new Ponto(4, 3);
        Ponto p2 = new Ponto(8, 5);
        Ponto p3 = new Ponto(9.2, 10);

        System.out.println("Distancia p1 entre e p2: " + p1.dist(p2));
        System.out.println("Distancia p1 entre e (5,2): " + p1.dist(5, 2));
        System.out.println("Distancia (4,3) entre e (5,2): " + Ponto.dist(4, 3, 5, 2));
        System.out.println("P1, P2, P3 sao triangulo:" + Ponto.isTriangulo(p1, p2, p3));
        System.out.println("Area retangulo:" + p1.getAreaRetangulo(p2));
        System.out.println("ID de P1: " + p1.getID());
        System.out.println("ID de P2: " + p2.getID());
        System.out.println("ID de P3: " + p3.getID());
        System.out.println("Next ID: " + Ponto.getNextID());
    }
}