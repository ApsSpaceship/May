

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P1764_kim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt(); // 들어 보지 못한 사람 수
		int m = sc.nextInt(); // 보지 못한 사람 수
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) { // 들어보지 못한 사람들을 map에 넣는다.
			map.put(sc.next(), i);
		}
		int count = 0;
		List<String> list = new LinkedList<>();
		for(int i = 0; i <m; i++) {
			String name = sc.next();
			if(map.get(name)!=null) { // map에 보지 못한 사람의 이름이 있으면 count증가, list에 저장한다.
				count++;
				list.add(name);
			}
		}
		Collections.sort(list); // 사전순으로 정렬
		sb.append(count).append("\n");
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
