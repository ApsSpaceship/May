class Solution {
    public int solution(String dirs) {
        int answer = 0;

        int[][] board = new int[11][11];

        int y = 5;
        int x = 5;
        for (int i = 0; i < dirs.length(); ++i) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if (y != 10) {
                        if ((board[y][x] & (1 << 0)) == 0 && (board[y + 1][x] & (1 << 1)) == 0)
                            ++answer;
                        board[y][x] |= (1 << 0);
                        ++y;
                    }
                    break;
                case 'D':
                    if (y != 0) {
                        if ((board[y][x] & (1 << 1)) == 0 && (board[y - 1][x] & (1 << 0)) == 0)
                            ++answer;
                        board[y][x] |= (1 << 1);
                        --y;
                    }
                    break;
                case 'R':
                    if (x != 10) {
                        if ((board[y][x] & (1 << 2)) == 0 && (board[y][x + 1] & (1 << 3)) == 0)
                            ++answer;
                        board[y][x] |= (1 << 2);
                        ++x;
                    }
                    break;
                case 'L':
                    if (x != 0) {
                        if ((board[y][x] & (1 << 3)) == 0 && (board[y][x - 1] & (1 << 2)) == 0)
                            ++answer;
                        board[y][x] |= (1 << 3);
                        --x;
                    }
                    break;
            }
        }

        return answer;
    }
}