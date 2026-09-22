/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class AFD {


public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int[][] transiciones = {
        {0, 0, 0},
        {0, 1, 2},
        {0, 3, 2},
        {0, 2, 2}
    };

    int estadoInicial = 1;
    int estadoAceptacion = 2;

    System.out.println("       AUTOMATA FINITO DETERMINISTA");

    System.out.println();

    System.out.println(
        "El Automata Finito Determinista esta definido sobre el lenguaje"
    );

    System.out.println(
        "Sigma = {0, 1}"
    );

    System.out.println(
        "y acepta el conjunto de palabras del lenguaje:"
    );

    System.out.println(
         "L = { 0*1(1|00|01)* }"
    );

    System.out.println();

    System.out.println(
        "Estado inicial: q1"
    );

    System.out.println(
        "Estado de aceptacion: q2"
    );

    System.out.println();

    System.out.print("Cuantas cadenas desea verificar?: ");
    int C = sc.nextInt();

    String[] cadenas = new String[C];
    boolean[] resultados = new boolean[C];

    for (int i = 0; i < C; i++) {

        System.out.print("Ingrese la cadena " + (i + 1) + ": ");
        cadenas[i] = sc.next();

        int estadoActual = estadoInicial;
        boolean valida = true;

        for (int j = 0; j < cadenas[i].length(); j++) {

            char simbolo = cadenas[i].charAt(j);

            if (simbolo != '0' && simbolo != '1') {
                valida = false;
                break;
            }

            int columna;

            if (simbolo == '0') {
                columna = 1;
            } else {
                columna = 2;
            }

            estadoActual =
                    transiciones[estadoActual][columna];
        }

        if (valida && estadoActual == estadoAceptacion) {
            resultados[i] = true;
        } else {
            resultados[i] = false;
        }
    }

    System.out.println();

    System.out.println("             RESULTADOS");

    for (int i = 0; i < C; i++) {

        if (resultados[i]) {
            System.out.println(
                cadenas[i] + " ACEPTADA"
            );
        } else {
            System.out.println(
                cadenas[i] + " RECHAZADA"
            );
        }
    }

    sc.close();
}
}
