import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        List<Integer> ans = new ArrayList<Integer>();

        String[] splitt = s.split("\\},\\{");
        int len = splitt.length;
        splitt[0] = splitt[0].replace("{", "");
        splitt[len - 1] = splitt[len - 1].replace("}", "");

        Arrays.sort(splitt, (o1, o2) -> o1.length() - o2.length());

        HashSet<Integer> HsSt = new HashSet<Integer>();
        for (int i = 0; i < len; ++i) {
            String[] splitt2 = splitt[i].split(",");
            for (int j = 0; j < splitt2.length; ++j) {
                int num = Integer.parseInt(splitt2[j]);
                if (!HsSt.contains(num)) {
                    HsSt.add(num);
                    ans.add(num);
                }
            }
        }

        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i)
            answer[i] = ans.get(i);

        return answer;
    }
}