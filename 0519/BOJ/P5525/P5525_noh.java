import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();

        int combo = -1;
        int ans = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (combo == -1) {
                if (str.charAt(i) == 'I')
                    combo = 0;
            } else if (str.charAt(i) != str.charAt(i - 1)) {
                if (str.charAt(i) == 'I') {
                    ++combo;
                    if (combo >= n)
                        ++ans;
                }
            } else {
                if (str.charAt(i) == 'I')
                    combo = 0;
                else
                    combo = -1;
            }
        }
        System.out.print(ans);
    }
}