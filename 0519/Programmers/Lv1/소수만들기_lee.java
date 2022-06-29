class Solution {
    static int answer;
    public int solution(int[] nums) {
        answer = 0;
        int len = nums.length;
        boolean[] visited = new boolean[len];
        comb(nums, visited, 0, len, 3);
        return answer;
    }
    
    public void comb(int[] nums, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                if(visited[i])
                    sum += nums[i];
            }
            if(isPrime(sum))
                answer++;
            return;
        }

        if (depth == n) {
            return;
        }
        visited[depth] = true;
        comb(nums, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        comb(nums, visited, depth + 1, n, r);
    }
    
    public boolean isPrime(int n) {		
		if(n < 2)
			return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
                return false;
		}
        return true;
	}
}