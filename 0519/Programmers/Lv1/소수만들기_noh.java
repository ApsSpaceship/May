class Solution {
    static boolean[] notPrime = new boolean[3001];
    static int n;

    public int solution(int[] nums) {
        n = nums.length;
        for (int i = 2; i <= 1500; ++i)
            if (!notPrime[i])
                for (int j = i + i; j <= 3000; j += i)
                    notPrime[j] = true;

        return Comb(0, 0, nums);
    }

    static int[] sel = new int[3];

    static int Comb(int idx, int sidx, int[] nums) {
        if (sidx == 3) {
            if (!notPrime[sel[0] + sel[1] + sel[2]])
                return 1;
            return 0;
        }
        int ret = 0;
        for (int i = idx; i <= n - 3 + sidx; ++i) {
            sel[sidx] = nums[i];
            ret += Comb(i + 1, sidx + 1, nums);
        }
        return ret;
    }
}