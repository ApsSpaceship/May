import java.util.Scanner;

public class P1780_lee {
	// 각 숫자 별 종이 개수
	static int[] pCnt;
	// 처음 시작 종이
	static int[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 종이 크기
		int n = sc.nextInt();
		// 개수 초기화
		pCnt = new int[3];
		// 종이 초기화
		paper = new int[n][n];
		// 종이 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				paper[i][j] = sc.nextInt();
		}
		// 모두 같은 수 이면 바로 리턴
		// 재귀 !
		checkAndCut(0, 0, n);
		// 출력
		for (int cnt : pCnt)
			System.out.println(cnt);
        sc.close();
	}

	// 종이 색상 비교 후 자르기
	public static void checkAndCut(int r, int c, int s) {

		// 만약 같은 색상으로 이루어져있다면 해당 색상 카운트를 증가시킨다.
		int color = isSame(r, c, s);
		if (color != 3) {
			pCnt[color]++;
			return;
		}

		int nextS = s / 3;

		// 9등분 한 후 각 종이 별 재귀
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				checkAndCut(r + i * nextS, c + j * nextS, nextS);
			}
		}

	}

	// 색 같은지 확인 후 색 여부 판단
	public static int isSame(int r, int c, int s) {
		int color = paper[r][c];
		for (int i = r; i < r + s; i++) {
			for (int j = c; j < c + s; j++) {
				if (color != paper[i][j])
					// 나올 수 없는 수 출력
					return 3;
			}
		}
		// 종이 개수 배열의 idx와 맞추기 위해
		return color + 1;
	}
}