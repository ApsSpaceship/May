package study_0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_1992_쿼드트리 {
	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < map.length; i++) {
			String a = sc.next();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = a.charAt(j)-'0';
			}
		}
		sb = new StringBuilder();
		check(0, 0, map.length);
		System.out.println(sb.toString());
	}

	private static void check(int r, int c, int length) {
		int n = map[r][c];
		boolean flag = true;
		out: for (int i = r; i < r + length; i++) {
			for (int j = c; j < c + length; j++) {
				if(map[i][j]!=n) {
					flag = false;
					break out;
				}
			}
		}
		if(flag) {
			sb.append(n);
			return;
		}else {
			sb.append("(");
			for(int i = r; i < r+length; i+=length/2) {
				for(int j = c; j < c+length; j+=length/2) {
					check(i,j,length/2);
				}
			}
			sb.append(")");
		}

	}

}
