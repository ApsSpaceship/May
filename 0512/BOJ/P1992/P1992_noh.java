import java.util.Scanner;

public class Main {
    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new char[n][n];
        for (int i = 0; i < n; ++i)
            board[i] = sc.next().toCharArray();

        quadTree(0, 0, n);

        System.out.print(sb);
    }

    static void quadTree(int y, int x, int size) {
        char ck = check(y, x, size);
        int halfSize = size / 2;
        if (ck == '2') {
            sb.append("(");
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 2; ++j) {
                    quadTree(y + i * halfSize, x + j * halfSize, halfSize);
                }
            }
            sb.append(")");
        } else
            sb.append(ck);
    }

    static char check(int y, int x, int size) {
        char num = board[y][x];
        for (int i = y; i < y + size; ++i)
            for (int j = x; j < x + size; ++j)
                if (board[i][j] != num)
                    return '2';
        return num;
    }
}