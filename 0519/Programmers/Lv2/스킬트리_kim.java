package study_0519;

import java.util.HashMap;
import java.util.Map;

public class Programmers_Lv2_스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACBDE"};
		Map<Character , Integer> map = new HashMap<>(); // 맵에 스킬 순서 저장하기
		for(int i = 0; i < skill.length(); i++) {
			map.put(skill.charAt(i), i+1);
		}
		int ans = 0;
		for(int i = 0; i < skill_trees.length; i++) {
			int order = 1; // 현재 최대로 사용 가능한 스킬 번호
			String check = skill_trees[i];
			boolean flag = true;
			for(int j = 0; j < check.length(); j++) {
				char now = check.charAt(j); // 판단 할 스킬
				if(map.get(now)==null) { // 그냥 사용할 수 있는 스킬
					continue;
				}else {
					if(map.get(now) > order) { // 내가 사용할 수 있는 스킬보다 뒤의 스킬
						flag = false;
						break;
					}else if(map.get(now) == order) { // 현재 최대로 사용 가능한 스킬 번호랑 같으면 최대 사용 가능한 스킬번호 1 증가
						order++;
					}else if(map.get(now) <= order) {
						continue;
					}
				}
			}
			if(flag) {
				ans++;
			}	
		}
		System.out.println(ans);
		
	}

}
