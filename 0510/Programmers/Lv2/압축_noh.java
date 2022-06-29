import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        msg += "0";
        int[] answer = {};

        int[] temp = new int[1000];
        int ansIdx = 0;

        Map<String, Integer> mapp = new HashMap<String, Integer>();
        int idx = 1;
        for (int i = 0; i < 26; ++i)
            mapp.put(Character.toString((char) ('A' + i)), idx++);

        StringBuilder input = new StringBuilder();
        for (int i = 0; i < msg.length() - 1; ++i) {
            input.append(msg.substring(i, i + 1));
            // 다음 문자까지 합친게 사전에 있으면
            if (mapp.get(input + msg.substring(i + 1, i + 2)) != null) {
                continue;
            }
            // 색인번호 출력
            temp[ansIdx++] = mapp.get(input.toString());
            // 사전 추가
            mapp.put(input + msg.substring(i + 1, i + 2), idx++);
            // 입력에서 제거
            input = new StringBuilder();
        }

        answer = new int[ansIdx];
        for (int i = 0; i < ansIdx; ++i)
            answer[i] = temp[i];

        return answer;
    }
}