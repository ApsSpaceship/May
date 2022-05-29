import java.util.Scanner;

public class Main {
    static int[][] board;
    static int[] ans = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                board[i][j] = sc.nextInt();

        solve(0, 0, n);

        for (int i = 0; i < 3; ++i)
            System.out.println(ans[i]);
    }

    static void solve(int y, int x, int size) {
        if (size == 1) {
            ++ans[board[y][x] + 1];
            return;
        }
        int ck = check(y, x, size);
        if (ck == -1) {
            int nSize = size / 3;
            solve(y, x, nSize);
            solve(y, x + nSize, nSize);
            solve(y, x + 2 * nSize, nSize);
            solve(y + nSize, x, nSize);
            solve(y + nSize, x + nSize, nSize);
            solve(y + nSize, x + 2 * nSize, nSize);
            solve(y + 2 * nSize, x, nSize);
            solve(y + 2 * nSize, x + nSize, nSize);
            solve(y + 2 * nSize, x + 2 * nSize, nSize);
        } else {
            ++ans[ck];
        }
    }

    // 다른게 있으면 -1 반환, 전부 같으면 그 숫자 + 1 반환
    static int check(int y, int x, int size) {
        int num = board[y][x];
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j)
                if (board[y + i][x + j] != num)
                    return -1;
        return num + 1;
    }
}