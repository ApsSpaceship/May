import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lv3_숫자게임 {
	public static void main(String[] args) {

		int[] A = { 5, 1, 3, 7 };
		int[] B = { 2, 2, 6, 8 };
		int answer = 0;
		//
		
		// 질 땐 크게 지고, 이길 땐 비슷하게 이기자~

		Arrays.sort(A);
		Arrays.sort(B);

		Deque<Integer> game = new ArrayDeque<>();

		int n = A.length;

		for (int i = 0; i < n; i++) {
			game.add(B[i]);
		}
		
		
		for (int i = n - 1; i >= 0; i--) {

			if (A[i] >= game.peekLast()) {
				game.pollFirst();
			} else {
				game.pollLast();
				answer++;
			}
		}
		System.out.println(answer);
	}
}
