package study_0512;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2178_미로탐색 {
	public static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int i = 0; i < n; i++) {
			String a = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = a.charAt(j) - '0';
			}
		} // 맵 입력 완료
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(0, 0));
		visited[0][0] = true;
		int ans = 1; // 시작위치도 포함해야 해서
		out: while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pos now = queue.poll();
				if(now.r==n-1 && now.c==m-1) {
					break out;
				}
				for (int k = 0; k < 4; k++) {
					int nr = now.r + dr[k];
					int nc = now.c + dc[k];
					if(nr >= 0 && nr < n && nc >= 0 && nc < m&&!visited[nr][nc]&&map[nr][nc]==1) {
						queue.add(new Pos(nr,nc));
						visited[nr][nc] = true;
					}
				}
			}
			ans++;
		}
		System.out.println(ans);

	}

}
