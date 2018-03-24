import java.io.*;
import java.util.Scanner;

public class Main {

public static int silnia(int n){
        if (n > 1) {
                n = n * silnia(n-1);
        }
        return n;
}
public static int b(int m, int i){
        int b = 0;
        if ((m % 2) == 0 && m > 2) {
                if (i < (m-1)) {
                        b = i;
                } else {
                        b = m - 2;
                }
        } else {
                b = m - 1;
        }
        return b;
}

public static void perm(int m, int[] p){
        int i, mi = 1, count = 0;
        int[] tab = new int[m+1];
        int temp = 0, x = 0;
        for (i = 1; i <= m; i++) {
                tab[i] = 1;
        }
        mi = 1;
        while (count < silnia(m)) {
                if (tab[mi] == mi) {
                        if (tab[mi] == 1 && mi == 1) {
                                count += 1;
                                System.out.println();
                                System.out.println("Permutacja " + count);
                                for (i = 1; i <= m; i++) {
                                        System.out.print(p[i]);
                                }
                                System.out.println("");
                        }
                        for (i = 1; i <= mi; i++) {
                                tab[i] = 1;
                        }
                        mi += 1;
                }
                if (tab[mi] < mi) {
                        x = b(mi, i);
                        temp = p[x];
                        p[x] = p[mi];
                        p[mi] = temp;
                        tab[mi] += 1;
                        mi = 1;
                }
        }

}
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą");
        int a = in.nextInt();
        int[] p = new int[a+1];
        for (int i = 1; i <= a; i++) {
                p[i] = i;
        }
        int x = silnia(a);
        perm(a, p);
}
}
