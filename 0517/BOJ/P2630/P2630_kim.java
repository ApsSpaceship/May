package study_0517;

import java.util.Scanner;

public class baekjoon_P2630_색종이 {
	static int[][] map;
	static int[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = new int[2];
		check(0, 0, n);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	private static void check(int r, int c, int length) {
		int n = map[r][c];
		boolean flag = true;
		out: for (int i = r; i < r + length; i++) {
			for (int j = c; j < c + length; j++) {
				if (map[i][j] != n) {
					flag = false;
					break out;
				}
			}
		}
		if (flag) {
			ans[n]++;
			return;
		} else {
			for (int i = r; i < r + length; i += length / 2) {
				for (int j = c; j < c + length; j += length / 2) {
					check(i, j, length / 2);
				}
			}
		}

	}

}
