// Zaimplementować rekurencyjną wersję algorytmu 13 generującego wszystkie podziały zbioru
// (na podstawie sposobu opisanego przed alg. 13 na stronie 3 i 4 wykładu numer 4)

import java.io.*;
import java.util.Scanner;

public class Main {

public static void algorytm(int n, int positions){
        int[] tablica = new int[positions];
        int difference, a = 0, b = 1;
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
                if (difference > 1) {
                        if (tablica[a] != tablica[b] && b < positions-1  ) {
                                tablica[b] += 1;
                                tablica[a] -= 1;
                        }
                        for (int i = 0; i < positions; i++) {
                                System.out.print(tablica[i]);
                                if (i < positions - 1) {
                                        System.out.print(" + ");
                                }
                        }
                }
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
