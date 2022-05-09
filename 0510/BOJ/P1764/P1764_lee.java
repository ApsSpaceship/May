import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1764_lee {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		// 인원 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dLen = Integer.parseInt(st.nextToken()); 
		int bLen = Integer.parseInt(st.nextToken());
        // 시간복잡도를 위해 
		HashSet<String> hs = new HashSet<String>();
		ArrayList<String> ans = new ArrayList<String>();
		// 입력
		for (int i = 0; i < dLen; i++) {
			hs.add(br.readLine());
		}
		// 입력 받으면서 확인해서 정답 배열에 넣기
		for (int i = 0; i < bLen; i++) {
			String b = br.readLine();
            // 시간 복잡도 고려
            // HashSet.contains 는 map 기반 구현 -> O(1)
            // ArrayList.contains 는 indexOf사용 -> Contains 여부 결정 -> O(n)
			if(hs.contains(b))
				ans.add(b);
		}
		// 사전순 정렬
		Collections.sort(ans);
		// 사이즈
		sb.append(ans.size()).append("\n");
		// 듣보잡들
		for(String s : ans) {
			sb.append(s).append("\n");
		}
		// 출력
		System.out.println(sb);
		br.close();
	}

}
