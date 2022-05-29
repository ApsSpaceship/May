class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < skill_trees[i].length(); j++) {
                for(int k = 0; k < skill.length(); k++) {
                    if(skill_trees[i].charAt(j) == skill.charAt(k)){
                        sb.append(k+1);
                        break;
                    }
                }
            }
            if(check(sb.toString()))
                answer++;
        } 
        return answer;
    }
    public boolean check(String str) {
        str.replace("0", "");
        int n = 1;
        for(int i = 0 ; i < str.length(); i++) {
            String idx = String.valueOf(n);
            if(String.valueOf(str.charAt(i)).equals(idx))
                n++; 
            else
                return false;
        }
        return true;
    }
}