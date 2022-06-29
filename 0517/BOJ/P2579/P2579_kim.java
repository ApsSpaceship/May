package study_0517;

import java.util.Scanner;

public class baekjoon_P2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] step = new int[n+1];
		for(int i = 1; i <= n; i++) {
			step[i] = sc.nextInt();
		}
		int[] dp = new int[n+1]; // 각 위치에서의 최댓값
		dp[1] = step[1];
		if(n >= 2) {
			dp[2] = step[1]+step[2];
		}
		if(n >= 3) {
			dp[3] = Math.max(step[1]+step[3],step[2]+step[3]);
			for(int i = 4; i <= n; i++) {
				dp[i] = Math.max(dp[i-2], dp[i-3]+step[i-1])+step[i];
			}
		}
		System.out.println(dp[n]);
		
		
	}

}
