import java.util.HashMap;
import java.util.Scanner;

public class bj_1620_나는야포켓몬마스터이다솜 {
public static void main(String[] args) {
	
	// 참고사항) 배열을 돌며 찾았더니 시간초과. 백만은 무리.
	
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt(); // 포켓몬 보유 수
	int M = sc.nextInt(); // 맞춰야 하는 수
	
	HashMap<String, Integer> findidx = new HashMap<>(); // 포켓몬 인덱스 출력
	HashMap<Integer, String> findpk = new HashMap<>(); // 포켓몬 출력
	
	
	for(int i=1; i<=N; i++) {
		
		String monster = sc.next();
		findidx.put(monster, i); // 인덱스저장
		findpk.put(i, monster);  // 포켓몬저장
	}
	
	StringBuilder sb = new StringBuilder();
	
	for(int i=0; i<M; i++) {
		String word = sc.next();
		
		if(word.charAt(0)>='1' && word.charAt(0) <='9') {
			// 만약 숫자면 해당 포켓몬 이름 출력
			int idx = Integer.parseInt(word);
			sb.append(findpk.get(idx));
		}else {
			// 포켓몬이면 해당 인덱스 출력
			sb.append(findidx.get(word));
		}
		sb.append("\n");
	}
	System.out.println(sb);
}
}
