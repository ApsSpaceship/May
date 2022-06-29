import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            String comm = sc.next();
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<Integer>();

            String input = sc.next();
            if (input.indexOf(",") == -1) {
                if (input.length() > 2)
                    list.add(Integer.parseInt(input.substring(1, input.length() - 1)));
            } else {
                String[] splitArr = input.split(",");
                splitArr[0] = splitArr[0].substring(1);
                splitArr[splitArr.length - 1] = splitArr[splitArr.length - 1].substring(0,
                        splitArr[splitArr.length - 1].length() - 1);

                for (int i = 0; i < splitArr.length; ++i)
                    list.add(Integer.parseInt(splitArr[i]));
            }

            int p1 = 0;
            int p2 = list.size() - 1;
            StringBuilder subStr = new StringBuilder();
            int dir = 1;
            for (int i = 0; i < comm.length(); ++i) {
                if (comm.charAt(i) == 'R') {
                    dir *= -1;
                } else {
                    if (p1 > p2) {
                        subStr.append("error");
                        break;
                    } else if (dir == 1) {
                        ++p1;
                    } else if (dir == -1) {
                        --p2;
                    }
                }
            }
            if (subStr.length() == 0) {
                if (dir == 1) {
                    subStr.append("[");
                    for (int i = p1; i < p2; ++i)
                        subStr.append(list.get(i) + ",");
                    if (p1 <= p2)
                        subStr.append(list.get(p2) + "");
                    subStr.append("]");
                } else {
                    subStr.append("[");
                    for (int i = p2; i > p1; --i)
                        subStr.append(list.get(i) + ",");
                    if (p1 <= p2)
                        subStr.append(list.get(p1) + "");
                    subStr.append("]");
                }
            }
            str.append(subStr + "\n");
        }
        System.out.println(str);
    }
}