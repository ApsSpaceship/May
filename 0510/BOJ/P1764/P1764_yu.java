
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class bj_1764_듣보잡 {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	StringBuilder sb = new StringBuilder();
	
	int n = sc.nextInt(); // 못들어본 사람
	int m = sc.nextInt(); // 못본사람
	
	HashMap<String, String> nosee = new HashMap<>();
	
	for(int i=0; i<n; i++) {
		nosee.put(sc.next(), "no");
	}
	
	int cnt = 0;
	
	List<String> pick = new LinkedList<>();
	
	for(int i=0; i<m; i++) {
		String word = sc.next();
		if(nosee.get(word)!=null) {
			cnt++;
			pick.add(word);
		}
	}
	
	Collections.sort(pick);
	
	System.out.println(cnt);
	for(int i=0; i<cnt; i++) {
		System.out.println(pick.get(i));
	}
}
}
