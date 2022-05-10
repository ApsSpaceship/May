
public class lv1_없는숫자더하기 {
	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,4,6,7,8,0};
		
		//
		
		int answer = 0;
		
		for(int i=0; i<=9; i++) {
			boolean flag = false;
			for(int j=0; j<numbers.length; j++) {
				if(numbers[j] == i) {
					flag = true;
				}
			}
			if(!flag) {
				answer+=i;
			}
		}
		
		System.out.println(answer);
	}

}
