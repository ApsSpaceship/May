

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_P1697_숨바꼭질 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001]; // 방문처리!
		queue.add(n);
		visited[n] = true;
		int ans = 0;
		if(n > k) { // 수빈이가 동생보다 앞에 있다면 수빈이 위치 - 동생 위치
			ans = n-k;
		}else if( n == k) { // 둘의 위치가 같다면 0
			ans = 0;
		}else {
			out:while(true) {
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					int num = queue.poll();
					if(num == k) { // 수빈이 위치가 동생 위치랑 같아지면 멈춤
						break out;
					}
					// 아직 다음 위치를 방문하지 않았을 때만 queue에 넣어주고 방문처리 해준다!!!
					if(num+1 <= 100000 && !visited[num+1]) {
						queue.add(num+1);
						visited[num+1] = true;
					}
				
					if( num-1 >= 0 && !visited[num-1]) {
						queue.add(num-1);
						visited[num-1] = true;
					}
					if( num*2 <= 100000 && !visited[num*2]) {
						queue.add(num*2);
						visited[num*2] = true;
					}
				}
				ans++;
			}
		}
		System.out.println(ans);		
	}
}
