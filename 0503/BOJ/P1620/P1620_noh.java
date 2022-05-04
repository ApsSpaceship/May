import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] idxToName = new String[n + 1];
        Map<String, Integer> nameToIdx = new HashMap<String, Integer>();

        for (int i = 1; i <= n; ++i) {
            String name = sc.next();
            idxToName[i] = name;
            nameToIdx.put(name, i);
        }
        for (int i = 0; i < m; ++i) {
            String input = sc.next();
            if ('0' <= input.charAt(0) && input.charAt(0) <= '9')
                sb.append(idxToName[Integer.parseInt(input)] + "\n");
            else
                sb.append(nameToIdx.get(input) + "\n");
        }
        System.out.print(sb);
    }
}