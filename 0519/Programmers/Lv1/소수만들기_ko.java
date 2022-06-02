class Solution {
    public int solution(int[] nums) {
        int answer = 0;
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) // 숫자 3개 합 조합(최소 3)
			for (int j = i + 1; j < len - 1; j++)
				for (int k = j + 1; k < len; k++)
					if (isPrime(nums[i] + nums[j] + nums[k]))
						answer++;

		return answer;
    }
    public static boolean isPrime(int num) { // 소수 판별
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;

		return true;
	}
}