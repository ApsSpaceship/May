
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1780_kim {
	static int[][] arr;
	static int minusone, zero, one;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 종이 입력 완료!

		map = new HashMap<>(); // -1,0,1일때의 종이의 개수 파악하기 위해 map으로 만듦
		map.put(-1, 0);
		map.put(0, 0);
		map.put(1, 0);

		check(0, 0, arr.length);
		System.out.println(map.get(-1)+"\n"+map.get(0)+"\n"+map.get(1));
	}

	private static void check(int r, int c, int length) {
		int n = arr[r][c]; // 처음 시작위치 값 저장
		boolean flag = true;
		out:for (int i = r; i < r+length; i++) {
			for (int j = c; j < c+length; j++) {
				if (arr[i][j] != n) { // 같지 않다면 flag=false
					flag = false;
					break out;
				}
			}
		}
		if (flag) {
			map.replace(n, map.get(n)+1); // 종이의 숫자가 다 같으면 그 숫자를 키로 value 가져와서 +1
		} else {
			for (int i = r; i <r +length; i += (length / 3)) {
				for (int j = c; j < c+length; j += (length / 3)) {
					check(i, j, length / 3);
				}
			}
		}
	}
}
