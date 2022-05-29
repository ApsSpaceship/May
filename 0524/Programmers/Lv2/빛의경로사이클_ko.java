import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
	static int[] dx = { 1, 0, -1, 0 }; // 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][][] visited;
	static int xLen;
	static int yLen;
    
    public int[] solution(String[] grid) {
     	List<Integer> answer = new ArrayList<>();
		xLen = grid.length;
		yLen = grid[0].length();

		visited = new boolean[xLen][yLen][4];
		for (int i = 0; i < xLen; i++)
			for (int j = 0; j < yLen; j++)
				for (int d = 0; d < 4; d++)
					if (!visited[i][j][d]) // 아직 사용하지 않은 방향
						answer.add(getC(grid, i, j, d));

		int size = answer.size();
		int[] ret = new int[size];
		for (int i = 0; i < size; i++)
			ret[i] = answer.get(i);

		Arrays.sort(ret);
		return ret;
	}

	public int getC(String[] grid, int x, int y, int d) {
		int cnt = 0; // 사이클 길이

		while (true) {
			if (visited[x][y][d]) // 사이클 완성
				break;

			cnt++;
			visited[x][y][d] = true; // 방문처리

			if (grid[x].charAt(y) == 'L')
				d = (d + 3) % 4;
			else if (grid[x].charAt(y) == 'R')
				d = (d + 1) % 4;

			x = (x + dx[d] + xLen) % xLen; // 맵 범위 고려
			y = (y + dy[d] + yLen) % yLen;
		}

		return cnt;
	}
}