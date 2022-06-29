import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] dy = { 1, -1, 0, 0 };
    static final int[] dx = { 0, 0, 1, -1 };

    static class Pos {
        int y;
        int x;
        int dist;

        public Pos(int y, int x, int dist) {
            super();
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] board = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; ++i)
            board[i] = sc.next().toCharArray();

        Queue<Pos> q = new LinkedList<Main.Pos>();
        q.add(new Pos(0, 0, 1));

        while (!q.isEmpty()) {
            int y = q.peek().y;
            int x = q.peek().x;
            int dist = q.poll().dist;
            if (visited[y][x])
                continue;
            visited[y][x] = true;
            if (y == n - 1 && x == m - 1) {
                System.out.println(dist);
                break;
            }
            for (int i = 0; i < 4; ++i) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && board[ny][nx] == '1')
                    q.add(new Pos(ny, nx, dist + 1));
            }
        }
    }
}