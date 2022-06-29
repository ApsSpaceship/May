package study_0517;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_P2606_바이러스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt(); // 노드 수
		int e = sc.nextInt(); // 간선 수
		List<Integer>[] list = new ArrayList[node+1]; // 인접리스트 만들기
		
		for(int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) { // 양방향노드
			int st = sc.nextInt();
			int ed = sc.nextInt();
			list[st].add(ed);
			list[ed].add(st);
		}
		boolean[] visited = new boolean[node+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		int ans = 0;
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i = 0; i < list[n].size(); i++) {
				if(!visited[list[n].get(i)]) {
					queue.add(list[n].get(i));
					visited[list[n].get(i)] = true;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
