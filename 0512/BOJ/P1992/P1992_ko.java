import java.util.Scanner;

public class P1992_ko {
	static String[][] pic;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		pic = new String[N][N];
		for (int i = 0; i < N; i++)
			pic[i] = sc.next().split("");

		slice(0, 0, N);

		System.out.print(sb);
	}

	static boolean check(int x, int y, int w) { // 너비 w만큼 같은 값인지 확인
		for (int i = x; i < x + w; i++)
			for (int j = y; j < y + w; j++)
				if (!pic[x][y].equals(pic[i][j])) // 하나라도 아니면 false
					return false;
		return true;
	}

	static void slice(int x, int y, int w) {
		if (check(x, y, w)) { // 시작점에서 너비 w만큼 같은 값인 경우
			sb.append(pic[x][y]);
			return;
		}
		sb.append("(");
		for (int i = x; i < x + w; i += w / 2) // 4분의 1로 쪼개기
			for (int j = y; j < y + w; j += w / 2)
				slice(i, j, w / 2);
		sb.append(")");
	}

}