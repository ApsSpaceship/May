

import java.util.Scanner;

public class baekjoon_P1676_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 25의 배수이면 0이 2개 더 붙어서 n/25 , 125의 배수이면 0이 3개 더 붙어서 n/125 해준다!
		int ans = (n/5)+(n/25)+(n/125); 
		System.out.println(ans);
		
	}

}
