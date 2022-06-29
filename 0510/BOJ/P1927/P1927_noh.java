import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            int oper = sc.nextInt();
            if (oper == 0) {
                if (pq.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(pq.poll() + "\n");
            } else {
                pq.add(oper);
            }
        }
        System.out.println(sb);
    }
}