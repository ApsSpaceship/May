class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
		boolean[] find = new boolean[10]; // 0~9 사용
		int len = numbers.length;
		
		for (int i = 0; i < len; i++) // 있으면 true
			find[numbers[i]] = true;
		
		for (int i = 0; i < 10; i++) // 없으면 더하기
			if (!find[i])
				answer += i;
		
		return answer;
    }
}