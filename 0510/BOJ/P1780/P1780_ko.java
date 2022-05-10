import java.util.Scanner;

public class Main {
	static int[][] paper;
	static int N;
	static int[] ans = new int[3]; // -1~1 -> 0~2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paper = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				paper[i][j] = sc.nextInt();

		slice(0, 0, N);

		for (int i = 0; i < 3; i++)
			System.out.println(ans[i]);
	}

	static boolean check(int x, int y, int w) { // 너비 w만큼 같은 숫자인지 확인
		int now = paper[x][y];
		for (int i = x; i < x + w; i++)
			for (int j = y; j < y + w; j++)
				if (paper[x][y] != paper[i][j]) // 하나라도 아니면 false
					return false;
		return true;
	}

	static void slice(int x, int y, int w) {
		if (check(x, y, w)) { // 시작점에서 너비 w만큼 같은 숫자인 경우 종이 합격
			ans[paper[x][y] + 1]++;
			return;
		}

		for (int i = x; i < x + w; i += w / 3) // 9분의 1로 쪼개기
			for (int j = y; j < y + w; j += w / 3)
				slice(i, j, w / 3);
	}

}
