import java.util.HashMap;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        HashMap<Character, Integer> HsMp = new HashMap<Character, Integer>();
        int idx = 0;
        for (int i = 0; i < skill.length(); ++i) {
            HsMp.put(skill.charAt(i), idx++);
        }

        outer: for (int i = 0; i < skill_trees.length; ++i) {
            int lastSkill = -1;
            for (int j = 0; j < skill_trees[i].length(); ++j) {
                if (HsMp.get(skill_trees[i].charAt(j)) == null)
                    continue;

                int curSkill = HsMp.get(skill_trees[i].charAt(j));
                if (curSkill - 1 != lastSkill) {
                    continue outer;
                }
                lastSkill = curSkill;
            }
            ++answer;
        }
        return answer;
    }
}