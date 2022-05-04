package study_0503;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_숫자게임 {
	public static void main(String[] args) {
		int[] A = {2,2,2,2};
		int[] B = {1,1,1,1};
		// 정렬 후 각각 queue에 담는다.
		Arrays.sort(A);
		Arrays.sort(B);
		Queue<Integer> aqueue = new LinkedList<>();
		Queue<Integer> bqueue = new LinkedList<>();
		for(int i = 0; i < A.length; i++) {
			aqueue.add(A[i]);
			bqueue.add(B[i]);
		}
		int ans = 0;
		while(!aqueue.isEmpty()&&!bqueue.isEmpty()) { // 큐가 비어있지 않을때까지 동작
			int anum = aqueue.peek();
			int bnum = bqueue.peek();
			// 배열 정렬 후 queue에 담아서 각 팀의 가장 작은 숫자부터 비교 시작!
			if(anum < bnum) { //b팀의 수가 더 크면
				ans++; // 승점 증가
				aqueue.poll(); // 각 queue에서 숫자 버린다. -> 사용 했으므로
				bqueue.poll();
			}else {
				bqueue.poll(); // b팀의 점수가 더 작으면 그 점수는 버리고
				// a팀의 점수보다 큰 점수가 나올 때 까지 숫자를 계속 버린다! -> a팀의 가장 작은 점수도 못이기면 이길 가능성 없어서!
				while(!bqueue.isEmpty()) {
					int num = bqueue.peek();
					if(num > anum) { 
						break;
					}else {
						bqueue.poll();
					}
				}
			}
		}
		System.out.println(ans);
	}

}
