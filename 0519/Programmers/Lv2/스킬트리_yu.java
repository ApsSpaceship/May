class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int n = skill_trees.length;
		
		for(int i=0; i<n; i++) { // 스킬트리 개수만큼 반복해서 체크
			
			int ni = skill_trees[i].length();
			
			int[] idxCheck = new int[ni]; //idx 저장할 배열
			
			for(int j=0; j<skill.length(); j++) {
				for(int k=0; k<ni; k++) {
					if(skill_trees[i].charAt(k) == skill.charAt(j)) {
						idxCheck[k]=j+1;
						break;
					}
				}
			} // idx 저장 완료
			
			boolean flag = true;
			int fstval = 0;
			int fstidx = 0;
			int cnt = 0;
			
			 for(int r=0; r<ni; r++) {
				 
				 if(idxCheck[r] == 0) {
					 continue;
				 }
				 
				 if(idxCheck[r] != 0) {
					fstval = idxCheck[r];
					fstidx = r;
					cnt++;
					break;
				 }
			}
			 
			 if(cnt>0 && fstval != 1) {
				 flag = false;
			 }
			 
			 if(fstidx < ni-1) {
			 for(int r=fstidx+1; r<ni; r++) {
				 if(idxCheck[r] == 0) {
					 continue;
				 }
				 
				 if(idxCheck[r] != fstval+1) {
					 flag = false;
					 break;
				 }
				 
				 fstval = idxCheck[r];
			 }
			 }
			 // "CBD" - {"CED"}
			
			
			if(flag) {
				answer++;
			}
			
		} // for end
        return answer;
    }
}