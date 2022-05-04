import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lv1_로또의최고순위와최저순위 {
	public static void main(String[] args) {

		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };

		//

		List<Integer> win = new ArrayList<>();

		for (int i = 0; i < win_nums.length; i++) {
			win.add(win_nums[i]);
		}

		int[] rank = { 6, 6, 5, 4, 3, 2, 1 };

		int zerocnt = 0;
		int same = 0;

		for (int i = 0; i < lottos.length; i++) {

			if (lottos[i] == 0) {
				zerocnt++;
			}

			if (win.contains(lottos[i])) {
				same++;
			}
		}

		int[] answer = new int[2];

		answer[0] = rank[same + zerocnt];
		answer[1] = rank[same];

		System.out.println(Arrays.toString(answer));

	}

}
