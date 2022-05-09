import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축_ko {

	public static int[] solution(String msg) {
		int mLen = msg.length();
		List<Integer> list = new ArrayList<>(); // 답 저장
		Map<String, Integer> map = new HashMap<>(); // 사전
		int mIdx = 27; // 사전 인덱스
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 26; i++) // 알파벳 사전에 입력
			map.put(Character.toString((char) ('A' + i)), i + 1);

		for (int i = 0; i < mLen; i++) {
			sb.append(msg.charAt(i));
			if (!map.containsKey(sb.toString())) { // 사전에 없다면
				list.add(map.get(sb.substring(0, sb.length() - 1))); // 사전에 있는 값의 사전 번호 출력
				map.put(sb.toString(), mIdx++); // 사전에 추가
				sb.setLength(0); // 스트링빌더 초기화
				i--;
			}
		}

		list.add(map.get(sb.toString())); // 남은 답 넣어주기

		int lLen = list.size();
		int[] answer = new int[lLen];
		for (int i = 0; i < lLen; i++) // 리턴할 배열에 옮기기
			answer[i] = list.get(i);

		return answer;
	}

}