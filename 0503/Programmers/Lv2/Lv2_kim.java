
import java.util.Arrays;
import java.util.Comparator;

public class programmers_파일명정렬2 {
	public static void main(String[] args) {
		String[] files = {"img000012345", "img1.png","img2","IMG02"};
		String[][] arr = new String[files.length][3]; // [0]: head, [1]: number,[2]: tail
		for(int i = 0; i < files.length; i++) {
			String a = files[i];
			int st = 0; // 숫자 시작점
			int ed = 0; // 숫자 끝나는 지점+1
			hi: for(int j = 0; j < a.length(); j++) {
				int n = a.charAt(j)-'0';
				if(n >=0 && n <=9) {
					st= j; // 숫자 시작 위치 저장
					if(j == a.length()-1) { // 숫자의 시작 위치가 파일명의 끝 부분이면
						ed = a.length(); // 숫자 끝나는 위치에 파일명 길이 넣어주고 break;
						break hi;
					}
					for(int k=j+1; k < j+5; k++) { // 숫자 최대 5개
						int c = a.charAt(k)-'0';
						if(c < 0 || c > 9) { // 숫자가 아니면
							ed = k; 
							break hi;
						}else if(k==a.length()-1) { // 숫자가 맞는데 파일명의 끝나는 지점이면
							ed = a.length();
							break hi;
						}
					}
					ed = j+5; // for문에서 걸러지지 않았으면 숫자 시작위치 이후 연속 4개가 모두 숫자라서 ed에 j+5 저장
					break hi;
				}				
			}
			arr[i][0] = a.substring(0, st);
			arr[i][1] = a.substring(st, ed);
			arr[i][2] = a.substring(ed, a.length());
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {						
			@Override
			public int compare(String[] o1, String[] o2) {			
				if(o1[0].toLowerCase().equals(o2[0].toLowerCase())) { // 대소문자 구별 없이 head부분 같으면
					int n1 = Integer.parseInt(o1[1]);
					int n2 = Integer.parseInt(o2[1]);
					return n1-n2; // 숫자부분 비교					
				}
				return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
			}
		});		
		String[] answer = new String[files.length];
		for(int i = 0; i < arr.length; i++) {
			answer[i] = arr[i][0]+arr[i][1]+arr[i][2];
		}
		System.out.println(Arrays.toString(answer));
	}
	

}
