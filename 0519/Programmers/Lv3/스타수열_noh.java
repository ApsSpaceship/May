class Solution {
    public int solution(int[] a) {
        int answer = -1;

        int len = a.length;
        if (len == 1)
            return 0;

        int[] cnt = new int[500000];
        int[][] memo = new int[500000][2];
        for (int i = 0; i < 500000; ++i)
            for (int j = 0; j < 2; ++j)
                memo[i][j] = -1;

        if (a[0] != a[1]) {
            ++cnt[a[0]];
            answer = Math.max(answer, cnt[a[0]]);
            memo[1][0] = a[0];
        }
        for (int i = 1; i < len - 1; ++i) {
            if (a[i] != a[i - 1] && memo[i - 1][0] != a[i]) {
                ++cnt[a[i]];
                answer = Math.max(answer, cnt[a[i]]);
                memo[i - 1][1] = a[i];
            } else if (a[i] != a[i + 1]) {
                ++cnt[a[i]];
                answer = Math.max(answer, cnt[a[i]]);
                memo[i + 1][0] = a[i];
            }
        }
        if (a[len - 1] != a[len - 2] && memo[len - 2][0] != a[len - 1]) {
            ++cnt[a[len - 1]];
            answer = Math.max(answer, cnt[a[len - 1]]);
            memo[len - 2][1] = a[len - 1];
        }

        return 2 * answer;
    }
}