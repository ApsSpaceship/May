import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_P1697 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈
		int K = sc.nextInt(); // 동생
		System.out.print(bfs(N, K));
	}

	static int bfs(int N, int K) {
		boolean[] visit = new boolean[100001]; // 0~100000 갈 수 있음
		Queue<Integer> q = new LinkedList<>();
		int next, now;
		int ret = 0; // 0초로 초기화

		q.add(N); // 시작 위치 방문
		visit[N] = true;
		while (N != K) { // 첫 값 같은 자리인지 확인
			int size = q.size();
			for (int i = 0; i < size; i++) { // 사이즈로 묶기
				now = q.poll();
				for (int j = 0; j < 3; j++) {
					if (j == 0)
						next = now - 1;
					else if (j == 1)
						next = now + 1;
					else
						next = now * 2;

					if (next < 0 || next > 100000 || visit[next]) // 다음 값 갈 수 있는지
						continue;

					if (next == K) // 찾았다면 끝
						return ++ret; // 다음 번에 갈 수 있으므로 +1

					q.add(next);
					visit[next] = true; // 갈 수 있으면 방문처리
				}
			}

			ret++; // 깊이
		}

		return ret;

	}

}