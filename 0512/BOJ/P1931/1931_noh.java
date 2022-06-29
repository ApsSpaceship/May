import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Conf implements Comparable<Conf> {
        int st;
        int ed;

        public Conf(int st, int ed) {
            super();
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Main.Conf o) {
            if (this.ed == o.ed)
                return this.st - o.st;
            return this.ed - o.ed;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Conf[] arr = new Conf[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = new Conf(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(arr);

        int time = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i].st >= time) {
                ++cnt;
                time = arr[i].ed;
            }
        }

        System.out.println(cnt);
    }
}