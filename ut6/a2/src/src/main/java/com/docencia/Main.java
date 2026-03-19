package com.docencia;

public class Main {
    public static void main(String[] args) {

        // varias notas
        System.out.println("Media 6,7,8 = " + CalculadoraNotas.calcularMedia(new int[]{6,7,8}));

        // una sola nota
        System.out.println("Media 10 = " + CalculadoraNotas.calcularMedia(new int[]{10}));

        // lista vacía
        try {
            CalculadoraNotas.calcularMedia(new int[]{});
        } catch (Exception e) {
            System.out.println("Correcto: error por lista vacía");
        }

        // nota fuera de rango
        try {
            CalculadoraNotas.calcularMedia(new int[]{5, 12});
        } catch (Exception e) {
            System.out.println("Correcto: error por nota fuera de rango");
        }
    }
}
