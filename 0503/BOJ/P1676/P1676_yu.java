import java.util.Scanner;

public class bj_1676_팩토리얼0의개수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 

		int cnt2 = 0;
		int cnt5 = 0;
		
		// 2*5 쌍의 결과가 0이 나오므로 쌍 개수가 답이 됨

		for(int i=1; i<=N; i++) {
			
			int num = i;
			
			while(num % 2 == 0) {
				cnt2++;
				num /= 2;
			}
			
			while(num% 5 == 0) {
				cnt5++;
				num /= 5;
			}
		}
		
		
		
		System.out.println(Math.min(cnt2, cnt5));
	}

}
