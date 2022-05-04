import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_P1620 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 포켓몬 수
		int M = sc.nextInt(); // 문제 수
		Map<String, String> nameMap = new HashMap<>(); // 번호에 해당하는 스트링
		Map<String, String> numMap = new HashMap<>(); // 이름에 해당하는 번호
		for (int i = 1; i <= N; i++) {
			String name = sc.next();
			nameMap.put(String.valueOf(i), name);
			numMap.put(name, String.valueOf(i));
		}

		for (int i = 0; i < M; i++) {
			String q = sc.next();
			if (nameMap.containsKey(q)) // 번호면 이름 이름이면 번호
				System.out.println(nameMap.get(q));
			else
				System.out.println(numMap.get(q));
		}

	}

}