import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
		String sub = s.substring(2, s.length() - 2);
		sub = sub.replaceAll("\\}", "");
		sub = sub.replaceAll("\\{", "");

		String[] subS = sub.split(",");
		int len = subS.length;
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < len; i++) {
			if (map.containsKey(subS[i]))
				map.put(subS[i], map.get(subS[i]) + 1);
			else
				map.put(subS[i], 1);
		}

		len = map.size();
		int[] answer = new int[len];
		for (String key : map.keySet()) {
			answer[len - map.get(key)] = Integer.parseInt(key);
		}

		return answer;
    }
}