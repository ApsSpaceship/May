import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int two = 0;
        int five = 0;
        for (int i = 2; i <= n; ++i) {
            int temp = i;
            while (temp % 2 == 0) {
                temp /= 2;
                ++two;
            }
            while (temp % 5 == 0) {
                temp /= 5;
                ++five;
            }
        }
        System.out.println(Math.min(two, five));
    }
}