package study_0517;

public class programmers_Lv1_내적 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] b = { -3, -1, 0, 2 };
		int ans = 0;
		for (int i = 0; i < a.length; i++) {
			ans += a[i] * b[i];
		}
		System.out.println(ans);
	}

}
