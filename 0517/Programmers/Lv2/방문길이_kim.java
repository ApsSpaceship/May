package study_0517;

import java.util.HashSet;
import java.util.Set;

public class Programmers_Lv2_방문길이 {
	static int[] dr = {-1, 1, 0, 0}; // 상(U)하(D)좌(L)우(R)
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		int r = 0; // 현재 위치 r
		int c = 0; // 현재 위치 c
		Set<String> set = new HashSet<>();
		int ans = 0;
		for(int i = 0; i < dirs.length(); i++) {
			char dir = dirs.charAt(i);
			int nextr = 0;
			int nextc = 0;
			switch(dir) {
			case 'U':
				nextr = r+dr[0];
				nextc = c+dc[0];
				break;
			case 'D':
				nextr = r+dr[1];
				nextc = c+dc[1];
				break;
			case 'L':
				nextr = r+dr[2];
				nextc = c+dc[2];
				break;
			case 'R':
				nextr = r+dr[3];
				nextc = c+dc[3];
				break;
			}
			if(nextr >= -5 && nextr <= 5 && nextc >= -5 && nextc <= 5 ) {
				// 현재위치와 다음에 이동할 위치가 set 안에 존재하지 않아야 방문한적 없는 것
				// 문자열로 나타내기 위해 가장 첫번째 숫자를 string으로 바꿈
				if(!set.contains(Integer.toString(r)+c+nextr+nextc)) { 
					ans++;
					set.add(Integer.toString(r)+c+nextr+nextc);
					set.add(Integer.toString(nextr)+nextc+r+c);					
				}
				r = nextr;
				c = nextc;
			}
			
		}
		System.out.println(ans);	
	}

}
