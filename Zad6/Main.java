// Zaimplementować rekurencyjną wersję algorytmu 13 generującego wszystkie podziały zbioru
// (na podstawie sposobu opisanego przed alg. 13 na stronie 3 i 4 wykładu numer 4)

import java.io.*;
import java.util.Scanner;

public class Main {

public static void algorytm(int n, int positions){
        int[] tablica = new int[positions];
        int difference, j = 1;
        boolean bool = false;
        // wypełniamy tablicę jedynkami
        for (int i = 0; i < positions; i++) {
                tablica[i] = 1;
        }
        if (n > positions) {
                difference = n - positions;
                tablica[0] += difference;
                for (int i = 0; i < positions; i++) {
                        System.out.print(tablica[i]);
                        if (i < positions - 1) {
                          System.out.print(" + ");
                        }
                }
                System.out.println(" = " + n);
                // if (difference > 1) {
                //         while (bool = false) {
                //                 while(tablica.length > 1 && tablica[j] > tablica[j+1]) {
                //                         tablica[0] -= 1;
                //                         tablica[j+1] += 1;
                //                         if (j < tablica.length - 1) {
                //                           j += 1;
                //                         }
                //                 }
                //         }
                // }
                if (positions > 1) {
                        algorytm(n,positions-1);
                }
        } else {
                for (int i = 0; i < positions; i++) {
                        System.out.print(tablica[i]);
                        if (i < positions - 1) {
                          System.out.print(" + ");
                        }
                }
                System.out.println(" = " + n);
                algorytm(n,positions-1);
        }
}


public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj liczbę n - ");
        int n = in.nextInt();
        algorytm(n,n);
}
}
