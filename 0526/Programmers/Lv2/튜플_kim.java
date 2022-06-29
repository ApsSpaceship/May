package study_0526;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_Lv2_튜플2 {
	public static void main(String[] args) {
		String s = "{{20,111},{111}}";
		int[] checked = new int[100001]; // 원소 1이상 100000 이하여서 범위 100001로 지정 , 등장 횟수 카운드함
		String[] checknum = s.split(",");
		for(int i = 0; i < checknum.length; i++) {
			String a = checknum[i];
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < a.length(); j++) {
				if(a.charAt(j) == '{' || a.charAt(j) == '}' || a.charAt(j) == ',') {
					continue;
				}
				sb.append(a.charAt(j));
			}
			checked[Integer.parseInt(sb.toString())]++;
		}
		int nums = 0; // 튜플에 원소가 몇 개 있는지 체크
		for(int i = 0; i < checked.length; i++) {
			if(checked[i] == 0) {
				continue;
			}
			nums++;
		}
		int[][] arr = new int[nums][2]; // [0] : 원소 , [1] : 원소가 나온 횟수
		int idx = 0;
		for(int i = 0; i < checked.length; i++) {
			if(checked[i] == 0) {
				continue;
			}
			arr[idx][0] = i;
			arr[idx][1] = checked[i];
			idx++;
		}
		// 내림차순으로 정렬(많이 나온 원소가 튜플 제일 앞에 위치해야 해서)
		Arrays.sort(arr, new Comparator<int[]>() { 
			@Override
			public int compare(int[] o1, int[] o2) {
				return -(o1[1]-o2[1]);
			}
		});
				
		int[] result = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i][0];
		}
		System.out.println(Arrays.toString(result));		
			
	}

}
