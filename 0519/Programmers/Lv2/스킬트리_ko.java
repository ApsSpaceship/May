class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int tLen = skill_trees.length;

		for (int t = 0; t < tLen; t++)
			if (count(skill, skill_trees[t]))
				answer++;

		return answer;
	}

	static boolean count(String skill_tree, String skill) {
		int sLen = skill.length();
		int[] index = new int[sLen + 1]; // 1~sLen 인덱스 사용
		boolean noMore = false;

		for (int s = 1; s <= sLen; s++) { // 맨 앞에서부터
			index[s] = skill_tree.indexOf(skill.charAt(s - 1)); // 스킬 트리 인덱스 확인
			if (index[s] == -1) { // 없다면
				noMore = true; // 더 이상 뒤 스킬은 사용 못 해
				continue;
			}

			if (noMore) // 있으면 안 돼
				return false;

			if (index[s - 1] > index[s]) // 스킬 사용 가능한데 스킬트리 순서 틀림
				return false;
		}

		return true;
	}

}