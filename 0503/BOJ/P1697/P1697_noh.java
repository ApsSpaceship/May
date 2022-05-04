import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        boolean[] visited = new boolean[200001];

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int cur = q.poll();
                if (visited[cur])
                    continue;
                visited[cur] = true;

                if (cur == k) {
                    System.out.println(time);
                    return;
                }

                if (cur - 1 >= 0)
                    q.add(cur - 1);
                if (cur + 1 <= 100000)
                    q.add(cur + 1);
                if (cur * 2 <= 200000)
                    q.add(cur * 2);
            }
            ++time;
        }
    }
}