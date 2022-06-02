import java.util.HashSet;
class Solution {

    public int solution(int[] a) {
		HashSet<Integer> set = new HashSet<>();
		int minL = Integer.MAX_VALUE;
		int minR = Integer.MAX_VALUE;
		int len = a.length;

		for (int i = 0; i < len; i++) {
			minL = Math.min(minL, a[i]);
			minR = Math.min(minR, a[len - 1 - i]);
			set.add(minL);
			set.add(minR);
		}

		return set.size();
	}

}