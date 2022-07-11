import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lv2_압축 {
	public static void main(String[] args) {

		String msg = "KAKAO";

		//

		ArrayList<String> alp = new ArrayList<>(Arrays.asList("1", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z"));
		
		List<Integer> ans = new ArrayList<>();
		
		outer: for(int i=0; i<msg.length(); i++) {
			int idx = i+2;
			while(idx<=msg.length()) {
				if(alp.contains(msg.substring(i, idx))) {
					idx++;
				}else {
					alp.add(msg.substring(i, idx));
					//System.out.println(msg.substring(i, idx));
					ans.add(alp.indexOf(msg.substring(i, idx-1)));
					//System.out.println(msg.substring(i, idx-1));
					i = idx-2;
					//System.out.println(i);
					break;
				}
			}
			// 마지막부분 처리
			if(idx>msg.length()) {
				ans.add(alp.indexOf(msg.substring(i, msg.length())));
				break outer;
			}
		}
		
		// 정답 배열로 출력
		int[] answer = new int[ans.size()];
		
		for(int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
