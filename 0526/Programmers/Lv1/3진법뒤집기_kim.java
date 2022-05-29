package study_0526;

public class Programmers_Lv1_3진법뒤집기 {
	public static void main(String[] args) {
		int n = 125;
		String sb = "";
		while(n > 0) {
			sb+=(n%3);
			n = n/3;
		}
		int sum = 0;
		for(int i = sb.length()-1; i >=0; i--) {
			if(sb.charAt(i) == '0') {
				continue;
			}
			int num = sb.charAt(i)-'0';
		    sum += num * Math.pow(3, sb.length()-1-i);
		}
		System.out.println(sum);
	}

}
