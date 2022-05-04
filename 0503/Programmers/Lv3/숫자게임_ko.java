import java.util.Arrays;

class Solution3 {

	public int solution(int[] A, int[] B) {
		int n = A.length;
		int answer = 0;
		int idxB = 0; // 확인할 B값 인덱스

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < n; i++)
			while(idxB < n) // B값 다 확인할 때까지
				if (A[i] < B[idxB++]) { // 이기면 다음 B값과 다음 A값 비교
					answer++;
					break;
				}

		return answer;
	}

}