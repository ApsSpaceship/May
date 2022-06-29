

import java.util.Arrays;

public class Lv1_kim {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] ans = new int[2]; // 최고 순위, 최저 순위
		boolean[] check = new boolean[46]; // 로또 45번까지 있음
		for(int i = 0; i < win_nums.length; i++) {
			check[win_nums[i]] = true;
		}
		check[0] = true;
		int collect = 0; // 일치하는 번호 파악
		int search = 0; // 0번 파악
		for(int i = 0; i < lottos.length; i++) {
			if(check[lottos[i]]) {
				collect++;
				if(lottos[i] == 0) {
					search++;
				}
			}
		}
		int[] rank = {6,6,5,4,3,2,1}; // 일치하는 숫자 개수에 대한 당첨순위 저장
		ans[0] = rank[collect];
		ans[1] = rank[collect-search];
		System.out.println(Arrays.toString(ans));
		
		
	}

}
