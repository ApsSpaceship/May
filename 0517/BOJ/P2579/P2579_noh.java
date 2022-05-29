import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[300];
        int[] cache = new int[300];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        cache[0] = arr[0];
        cache[1] = arr[0] + arr[1];
        cache[2] = Math.max(cache[0], arr[1]) + arr[2];

        for (int i = 3; i < n; ++i)
            cache[i] = Math.max(cache[i - 2], cache[i - 3] + arr[i - 1]) + arr[i];

        System.out.println(cache[n - 1]);
    }
}