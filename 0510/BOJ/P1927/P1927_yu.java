import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_1927_최소힙 {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	int n = sc.nextInt();
	
	StringBuilder sb = new StringBuilder();
	
	for(int i = 0; i<n; i++) {
		
		int num = sc.nextInt();
		
		if(num == 0) {
			if(pq.isEmpty()) {
				sb.append(0).append("\n");
			}else {
				sb.append(pq.poll()).append("\n");
			}
		}else {
			pq.add(num);
			//System.out.println(sb.toString());
		}
	}
	
	System.out.println(sb);
}
}
