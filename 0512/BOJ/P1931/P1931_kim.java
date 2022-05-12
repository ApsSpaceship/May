package study_0512;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baekjoon_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] meeting = new int[n][2]; // [0] : 시작시간, [1] : 끝나는시간
		for (int i = 0; i < n; i++) {
			meeting[i][0] = sc.nextInt();
			meeting[i][1] = sc.nextInt();
		}
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		
		int ans = 0;
		int finish = 0;
		for(int i = 0; i < meeting.length; i++) {
			if(meeting[i][0] >= finish) {
				finish = meeting[i][1];
				ans++;
			}
		}
		
		System.out.println(ans);
		

	}

	

}
