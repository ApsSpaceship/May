import java.util.Scanner;

public class Main_P1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 숫자 입력
		int cnt = 0;
		int np;
		for (int i = n; i >= 5; i--) { // 5개수로 0개수 세기
			np = i;
			while (np % 5 == 0) {
				cnt++;
				np /= 5;
			}
		}
		System.out.print(cnt);
	}

}
