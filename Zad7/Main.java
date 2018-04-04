// Skonstruować i zaimplementować algorytm znajdujący wszystkie k-elementowe kompozycje liczby n –
import java.io.*;
import java.util.Scanner;

public class Main{

  public static boolean checkifgood(int[][] tab, int n, int i){
    int suma = 0;
    for (int j = 0; j < n; j++) {
      suma += tab[i][j];
    }
    if (suma == n) {
      return true;
    } else {
      return false;
    }
  }
  public static void kompozycje(int k, int n, int count, int[][] tablica){
    boolean isgood;
    if (n > 0) {
      if (count < k) {
        for (int i = 0; i <= n - 1; i++) {
          for (int j = 0; j <= k - 1; j++ ) {
            tablica[i][j] = i;
            System.out.print(tablica[i][j]);
          }
          isgood = checkifgood(tablica, n, i);
          System.out.println();
          System.out.println(isgood);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Podaj liczbę k - ");
    int k = in.nextInt();
    System.out.print("Podaj liczbę n - ");
    int n = in.nextInt();
    int[][] tablica = new int[n][k];
    int count = 1;
    Main start = new Main();
    kompozycje(k, n, count, tablica);
  }
}
