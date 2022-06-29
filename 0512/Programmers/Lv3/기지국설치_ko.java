class Solution {
    public int solution(int n, int[] stations, int w) {
      	int answer = 0;
		int sLen = stations.length;
		int start = 1;
		int idx = 0;
		int end;
		int effect = w * 2 + 1;
		while (start <= n && idx < sLen) {
			end = stations[idx] - w - 1;// 이번 station 영향 앞까지
			if (end >= start) {
				answer += (end - start + 1) / effect;
				if ((end - start + 1) % effect > 0)
					answer++;
			}
			start = stations[idx++] + w + 1; // 전 station 영향 다음부터
		}
		if (start <= n)
			answer += Math.ceil(((double) (n - start + 1) / effect));
		return answer;
    }
}