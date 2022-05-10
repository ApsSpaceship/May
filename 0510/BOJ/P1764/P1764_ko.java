import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 듣x 수
		int M = sc.nextInt();// 보x 수
		int cnt = 0; // 듣보x 수
		String input;
		Map<String, Boolean> map = new HashMap<>(N);
		List<String> list = new ArrayList<>(N);
		
		for (int i = 0; i < N; i++) // 듣x
			map.put(sc.next(), true);
		for (int i = 0; i < M; i++) {
			input = sc.next();
			if (map.containsKey(input)) { // 듣보x면
				cnt++;
				list.add(input);
			}
		}
		Collections.sort(list); // 정렬
		
		System.out.println(cnt);
		for(int i =0; i<cnt; i++)
			System.out.println(list.get(i));
	}

}

