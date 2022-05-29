import java.util.Scanner;

public class Main {
    static int[][] board;
    static int[] ans = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                board[i][j] = sc.nextInt();

        solve(0, 0, n);

        for (int i = 0; i < 2; ++i)
            System.out.println(ans[i]);
    }

    static void solve(int y, int x, int size) {
        if (size == 1) {
            ++ans[board[y][x]];
            return;
        }
        int ck = check(y, x, size);
        if (ck == -1) {
            int nSize = size / 2;
            for (int i = 0; i < 2; ++i)
                for (int j = 0; j < 2; ++j)
                    solve(y + i * nSize, x + j * nSize, nSize);
        } else {
            ++ans[ck];
        }
    }

    // 다른게 있으면 -1 반환, 전부 같으면 그 숫자 반환
    static int check(int y, int x, int size) {
        int num = board[y][x];
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j)
                if (board[y + i][x + j] != num)
                    return -1;
        return num;
    }
}