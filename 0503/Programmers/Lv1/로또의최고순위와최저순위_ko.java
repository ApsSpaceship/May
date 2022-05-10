import java.util.HashMap;
import java.util.Map;

class Solution1 { // 맵 사용한 풀이
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		Map<Integer, Boolean> map = new HashMap<>(6);
		answer[1] = 7;
		int plus = 0;
		for (int i = 0; i < 6; i++)
			map.put(win_nums[i], true);
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0)
				plus++;
			else if (map.containsKey(lottos[i]))
				answer[1]--;
		}

		answer[0] = answer[1] - plus;

		for (int i = 0; i < 2; i++)
			if (answer[i] == 7)
				answer[i] = 6;

		return answer;
	}

}

class Solution2 { // 반복문 풀이
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		answer[1] = 7;
		int plus = 0;
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				plus++;
				continue;
			}
			for (int j = 0; j < 6; j++)
				if (lottos[i] == win_nums[j]) { // 일치하면 등수 감소
					answer[1]--;
					break;
				}
		}
		answer[0] = answer[1] - plus;

		for (int i = 0; i < 2; i++)
			if (answer[i] == 7)
				answer[i] = 6;

		return answer;
	}
}
