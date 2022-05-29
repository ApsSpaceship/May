import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> mapp = new TreeMap<String, Integer>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; ++i) {
			String name = sc.next();
			mapp.put(name, 1);
		}
		int cnt = 0;
		for (int i = 0; i < m; ++i) {
			String name = sc.next();
			if (mapp.get(name) != null) {
				mapp.put(name, 2);
				++cnt;
			}
		}
		System.out.println(cnt);
		for (String name : mapp.keySet())
			if (mapp.get(name) == 2)
				System.out.println(name);
	}
}