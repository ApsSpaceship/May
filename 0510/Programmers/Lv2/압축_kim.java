
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 압축_kim {
	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";
		Map<String, Integer> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		int top = 26;
		for(int i = 0; i < alphabet.length; i++) {
			map.put(alphabet[i], i+1);
		}
		int now = 0;
		int next = 0;
		bye: for(int i = 0; i < msg.length(); i++) {
			now = i;
			next = i;
			int count = 0;
			out: while(true) {
				if(next+1 <= msg.length()) {
					next += 1;
					count++;
					String check = msg.substring(now, next);
					if(!map.containsKey(check)) {
						map.put(check, ++top);
						list.add(map.get(msg.substring(now,next-1)));
						break out;
					}
				}else {
					list.add(map.get(msg.substring(now,next)));
					break bye;
				}
				
			}		
			if(i != msg.length()-1) {
				i += (count-2);
			}			
		}
		int[] ans = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		System.out.println(Arrays.toString(ans));		
	}
}
