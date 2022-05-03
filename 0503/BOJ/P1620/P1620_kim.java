
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P1620_kim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int m = sc.nextInt();
		int n = sc.nextInt();
		List<String> poket = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < m; i++) {
			String poketmon = sc.next();
			poket.add(poketmon); // 포켓몬 저장
			map.put(poketmon, i); // 포켓몬 이름과 번호를 매핑해서 이름으로 번호를 찾기 쉽게 한다.
		}
		for(int i = 0; i < n; i++) {
			String a = sc.next();
			if(a.charAt(0)-'0' >= 0 && a.charAt(0)-'0' <= 9) {
				sb.append(poket.get(Integer.parseInt(a)-1)).append("\n"); // 인덱스가 0부터 시작이라 -1 해주었다.
				
			}else {
				sb.append(map.get(a)+1).append("\n"); // 인덱스가 0부터 시작이라 +1 해주었다.
			}
		}
		System.out.println(sb.toString());
		
	}

}
