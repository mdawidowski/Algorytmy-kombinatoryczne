public class Main {

public static String[][] init_table(String[][] table){
        for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                        table[i][j] = " | ";
                }
        }
        return table;
}

public static String[][] put_signs(String[][] table, int i, int j){
        table[i][j] = "X | ";
        int b = j;
        for (int a = 0; a < table.length; a++) {
                if (table[i][a] == " | ") {
                        table[i][a] = "O | ";
                }
        }
        for (int a = 0; a < table.length; a++) {
                if (table[a][j] == " | ") {
                        table[a][j] = "O | ";
                }
        }
        for (int a = i; a < table.length; a++, b++) {
                if (a < table.length-1 && b < table.length - 1) {
                        if (table[a+1][b+1] == " | ") {
                                table[a+1][b+1] = "O | ";
                        }
                }
        }
        b = j;
        for (int a = i; a < table.length; a++, b--) {
                if (a < table.length-1 && b > 0) {
                        if (table[a+1][b-1] == " | ") {
                                table[a+1][b-1] = "O | ";
                        }
                }
        }
        return table;
}

public static String[][] put_hetmans(String[][] table){
        for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                        if (table[i][j]== " | ") {
                                table = put_signs(table, i, j);
                        }
                }
        }

        return table;
}

public static void main(String[] args) {
        String[][] table = new String[8][8];
        table = init_table(table);
        table = put_hetmans(table);
        for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                        System.out.print(table[i][j]);
                }
                System.out.println();
        }
}
}
