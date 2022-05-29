class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        if (stations[0] - w > 1)
            answer += (stations[0] - w - 1 - 1) / (2 * w + 1) + 1;
        for (int i = 1; i < stations.length; ++i) {
            int diff = stations[i] - stations[i - 1] - 1;
            if (diff > 2 * w)
                answer += (diff - 2 * w - 1) / (2 * w + 1) + 1;
        }
        if (n - stations[stations.length - 1] - w > 0)
            answer += (n - stations[stations.length - 1] - w - 1) / (2 * w + 1) + 1;

        return answer;
    }
}