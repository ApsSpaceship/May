package study_0524;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_Lv2_빛의경로사이클 {
	
	static boolean[][][] visited;
	static int R,C;
	static char[][] arr;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		
		String[] grid = {"R","R"};
		R = grid.length;
		C = grid[0].length();
		
		arr = new char[R][C];
		for(int i = 0; i < R; i++) {
			String s = grid[i];
			for(int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}		
		visited = new boolean[R][C][4]; // 각 칸에서 4방향으로 이동 가능(상 우 하 좌)
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				for(int d = 0; d < 4; d++) {
					if(!visited[i][j][d]) {
						check(i,j,d);
					}
				}
			}
		}
		int[] ans = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		Arrays.sort(ans);
		System.out.println(Arrays.toString(ans));
		
	}
    
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	private static void check(int r, int c, int d) {	
		int length = 0;
		
		while(true) {
			if(visited[r][c][d]) {
				break;
			}
			length++;
			visited[r][c][d] = true;
			if(arr[r][c] == 'R') {
				d = (d == 0 ? 3 : d-1);
			}else if(arr[r][c] == 'L') {
				d = (d == 3 ? 0 : d+1);
			}
			
			r = (r + dr[d] + R) % R; // 범위 확인
			c = (c + dc[d] + C) % C; 
		}
		
		list.add(length);
		return;	
	}
}
