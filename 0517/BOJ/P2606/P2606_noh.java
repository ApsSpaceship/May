import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] adj = new ArrayList[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; ++i)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1);

        int ans = -1;
        for (int i = 1; i <= n; ++i)
            if (visited[i])
                ++ans;
        System.out.println(ans);
    }

    static void dfs(int cur) {
        if (visited[cur])
            return;
        visited[cur] = true;

        for (int next : adj[cur]) {
            if (!visited[next])
                dfs(next);
        }
    }
}