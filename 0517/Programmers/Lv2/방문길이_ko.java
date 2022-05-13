import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(String dirs) {
		Map<String, Boolean> map = new HashMap<>();
		int len = dirs.length();
		int[] dx = { -1, 1, 0, 0 }; // 상하우좌
		int[] dy = { 0, 0, 1, -1 };
		int x = 0; // -5~5사용
		int y = 0;
		int nx;
		int ny;
		int mode = 0;
        
		for (int i = 0; i < len; i++) {
			switch (dirs.charAt(i)) {
			case 'U':
				mode = 0;
				break;
			case 'D':
				mode = 1;
				break;
			case 'R':
				mode = 2;
				break;
			case 'L':
				mode = 3;
				break;
			}
			nx = x + dx[mode];
			ny = y + dy[mode];
			if (nx < -5 || ny < -5 || nx > 5 || ny > 5) // 범위 벗어나면 무시
				continue;
			map.put(Integer.toString(nx) + ny + x + y, true); // 양방향 모두 저장
			map.put(Integer.toString(x) + y + nx + ny, true);
			x = nx; // 현재 위치 변경
			y = ny;
		}

		int answer = map.size() / 2;
		return answer;
	}
}