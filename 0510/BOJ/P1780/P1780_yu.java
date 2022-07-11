import java.util.Scanner;

public class bj_1780_종이의개수 {

	static int n;
	static int[][] paper;
	static int[] cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // N

		paper = new int[n][n];

		cnt = new int[3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				paper[i][j] = sc.nextInt();
			}
		} // 입력받기
		
		divide(0, 0, n); // 분할정복!!!
		
		for(int i=0; i<3; i++) {
			System.out.println(cnt[i]);
		}

	}

	public static boolean pcheck(int row, int col, int len) {
		int num = paper[row][col];
		for (int i = row; i < row + len; i++) {
			for (int j = col; j < col + len; j++) {
				if (paper[i][j] != num) {
					return false;
				}
			}
		}
		return true;
	}
	
	 public static void divide(int row, int col, int len) {  
	        if(pcheck(row, col, len)) {
	            int num = paper[row][col];
	            cnt[num + 1] ++; //-1때문에 "값+1 == 인덱스"
	        }else {
	            int nextLen = len / 3;
	            for(int i = 0; i < 3; i++) {
	                for(int j = 0; j < 3; j++) {
	                	divide(row + i*nextLen, col + j*nextLen, nextLen);
	                }
	            }
	        }
	    }
}
