import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int input;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			input = sc.nextInt();
			if (input == 0) { // 0인 경우
				if (q.isEmpty()) // 남은게 없다면 0
					sb.append(0 + "\n");
				else
					sb.append(q.poll() + "\n");
			} else
				q.add(input);
		}
		System.out.print(sb);
	}

}