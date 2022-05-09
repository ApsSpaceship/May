import java.util.PriorityQueue;
import java.util.Scanner;

public class P1927_lee {
	public static void main(String[] args) {
		// N 개의 연산
		// 연산 정보 x
		// x 가 자연수이면 배열에 x 추가
		// x가 0이면 배열에서 가장 작은 값 출력 후 배열에서 제거
		// x 가 2^31 보다 작은 자연수 또는 0이고 음의 정수 아님
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();	
			if(input == 0 && pq.isEmpty()) {
				sb.append(0).append("\n");
			}else if(input == 0 && !pq.isEmpty()) {
				sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(input);
			}
		}
		System.out.println(sb);
		sc.close();
	}
}