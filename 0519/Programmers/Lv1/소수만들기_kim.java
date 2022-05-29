package study_0519;

public class Programmers_Lv1_소수만들기 {
	static int[] nums;
	static int[] sel;
	static int ans;
	public static void main(String[] args) {
		nums = new int[] {1,2,3,4};
		sel = new int[3];
		ans = 0;
		check(0,0);
		System.out.println(ans);
				
	}
	private static void check(int idx, int sidx) {
		if(idx == 3) {
			int sum = 0;
			for(int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			for(int i = 2; i <= Math.sqrt(sum); i++) {
				if( sum % i == 0) {
					return;
				}
			}
			ans++;		
			return;
		}else if(sidx == nums.length) {
			return;
		}else {
			sel[idx] = nums[sidx];
			check(idx+1, sidx+1);
			check(idx , sidx+1);
		}
		
	}

}
