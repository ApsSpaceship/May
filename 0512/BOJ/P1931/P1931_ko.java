import java.util.Arrays;
import java.util.Scanner;

public class P1931_ko {
	static class Meet implements Comparable<Meet> {
		int s;
		int f;

		public Meet(int s, int f) {
			this.s = s;
			this.f = f;
		}

		@Override
		public int compareTo(Meet o) {
			if (this.f == o.f) // 끝나는 시간 같으면
				return this.s - o.s; // 시작하는 시간 기준 정렬
			return this.f - o.f;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 1; // 최소 회의 1개 가능
		int N = sc.nextInt();
		Meet[] mList = new Meet[N];

		for (int i = 0; i < N; i++)
			mList[i] = new Meet(sc.nextInt(), sc.nextInt());

		Arrays.sort(mList); // 정렬

		int nF = mList[0].f; // 앞 회의 끝나는 시간은 맨 앞 회의로 초기화
		for (int i = 1; i < N; i++)
			if (mList[i].s >= nF) { // 가능한 회의
				nF = mList[i].f; // 끝나는 시간 변경
				ans++;
			}

		System.out.print(ans);
	}

}