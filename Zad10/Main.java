import java.io.*;
import java.util.Scanner;

public class Main {
public static int getsize(){
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj wartość n: ");
        int size = in.nextInt();
        return size;
}
public static int sieve1(int number, int[] table){
        int ret_number = 0;
        for (int x = 0; x < table.length; x++) {
                for (int y = 0; y < table.length; y++) {
                        if(number == table[x] + table[y] && table[x] != table[y] && table[x] != 0 && table[y] != 0) {
                                ret_number = number;
                        }
                }
        }
        return ret_number;
}
public static int sieve2(int number, int[] table){
        int ret_number = number;
        int count = 0;
        for (int x = 0; x < table.length; x++) {
                for (int y = x + 1; y < table.length; y++) {
                        if(number == table[x] + table[y] && table[x] != table[y] && table[x] != 0 && table[y] != 0) {
                                count += 1;
                        }
                }

        }
        if (count > 1) {
          ret_number = 0;
        }
        return ret_number;
}
public static int sieving(int number, int[] table){
        number = sieve1(number, table);
        if (number > 0) {
                number = sieve2(number, table);
        }
        return number;
}
public static void main(String[] args) {
        int size = getsize();
        int index = 2, to_check = 0;
        int[] table =  new int[size];
        table[0] = 1;
        table[1] = 2;
        for (int x = 2; x <= size; x++) {
                to_check = sieving(x, table);
                if (to_check > 0) {
                        table[index] = to_check;
                        index += 1;
                }
        }
        int x = 0;
        while(x < table.length) {
                if (table[x] > 0) {
                        System.out.println(table[x]);
                }
                x += 1;
        }
}
}
