import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178_ko {
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] maze;
	static int N;
	static int M;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String now = sc.next();
			for (int j = 0; j < M; j++)
				maze[i][j] = now.charAt(j) - '0';
		}

		System.out.print(bfs(new Point(0, 0)));
	}

	static int bfs(Point s) {
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || (nx == 0 && ny == 0))
					continue;
				if (maze[nx][ny] == 1) { // 아직 방문하지 않은 경우
					q.add(new Point(nx, ny));
					maze[nx][ny] = maze[x][y] + 1;
				}
			}

		}

		return maze[N - 1][M - 1];
	}

}