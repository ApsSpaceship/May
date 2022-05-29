import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] grid) {
        int[] answer = {};

        int Y = grid.length;
        int X = grid[0].length();
        char[][] board = new char[Y][X];
        boolean[][][] onCycle = new boolean[Y][X][4];
        for (int i = 0; i < grid.length; ++i) {
            board[i] = grid[i].toCharArray();
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < Y; ++i) {
            for (int j = 0; j < X; ++j) {
                for (int d = 0; d < 4; ++d) {
                    if (!onCycle[i][j][d]) {
                        int y = i;
                        int x = j;
                        int dir = d;
                        int len = 0;
                        while (true) {
                            // 사이클 찾으면
                            if (len != 0 && y == i && x == j && dir == d) {
                                ans.add(len);
                                break;
                            }

                            onCycle[y][x][dir] = true;

                            // 북
                            if (dir == 0) {
                                if (y == 0) {
                                    y = Y - 1;
                                } else {
                                    --y;
                                }
                            }
                            // 동
                            else if (dir == 1) {
                                if (x == X - 1) {
                                    x = 0;
                                } else {
                                    ++x;
                                }
                            }
                            // 남
                            else if (dir == 2) {
                                if (y == Y - 1) {
                                    y = 0;
                                } else {
                                    ++y;
                                }
                            }
                            // 서
                            else if (dir == 3) {
                                if (x == 0) {
                                    x = X - 1;
                                } else {
                                    --x;
                                }
                            }

                            switch (board[y][x]) {
                                case 'L':
                                    dir = ((dir - 1) == -1 ? 3 : dir - 1);
                                    break;
                                case 'R':
                                    dir = (dir + 1) % 4;
                                    break;
                            }

                            ++len;
                        }
                    }
                }
            }
        }

        ans.sort(null);

        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i)
            answer[i] = ans.get(i);

        return answer;
    }
}