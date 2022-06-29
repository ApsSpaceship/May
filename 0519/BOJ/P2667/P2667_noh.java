import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int[] dy = { 1, -1, 0, 0 };
    static final int[] dx = { 0, 0, 1, -1 };
    static int n;
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; ++i)
            board[i] = sc.next().toCharArray();

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (board[i][j] == '1' && !visited[i][j])
                    ans.add(dfs(i, j));

        ans.sort((o1, o2) -> o1 - o2);

        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); ++i)
            System.out.println(ans.get(i));
    }

    static int dfs(int y, int x) {
        if (visited[y][x])
            return 0;
        visited[y][x] = true;

        int ret = 1;
        for (int i = 0; i < 4; ++i) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < n && 0 <= nx && nx < n && board[ny][nx] == '1' && !visited[ny][nx])
                ret += dfs(ny, nx);
        }
        return ret;
    }
}