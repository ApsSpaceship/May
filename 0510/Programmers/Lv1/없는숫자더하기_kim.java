
public class 없는숫자더하기_kim {
	public static void main(String[] args) {
		int[] numbers = {5,8,4,0,6,7,9};
		int sum = 45;
		for(int i = 0; i < numbers.length; i++) {
			sum -= numbers[i];
		}
		System.out.println(sum);
	}

}
