package study_0524;

public class Programmers_Lv1_약수의개수와덧셈 {
	public static void main(String[] args) {
		int left = 24;
		int right = 27;
		int sum = 0;
		for(int i = left; i <= right; i++) {
			int count = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			sum = (count%2==0?sum+i:sum-i);
		}
		System.out.println(sum);
	}

}
