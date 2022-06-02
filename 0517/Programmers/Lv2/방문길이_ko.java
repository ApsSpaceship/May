import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
		int len = dirs.length();
		int[] dx = { -1, 1, 0, 0 }; // 상하우좌
		int[] dy = { 0, 0, 1, -1 };
		int x = 0; // -5~5사용
		int y = 0;
		int nx, ny;
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
            if (nx < -5 || ny < -5 || nx > 5 || ny > 5)
				continue;
			set.add(Integer.toString(nx) + ny + x + y);
			set.add(Integer.toString(x) + y + nx + ny);
			x = nx;
			y = ny;
		}
		return set.size()/2;
    }
}
