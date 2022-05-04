class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer = new int[2];

        int zero = 0;
        int same = 0;
        for (int i = 0; i < lottos.length; ++i) {
            if (lottos[i] == 0) {
                ++zero;
                continue;
            }
            for (int j = 0; j < win_nums.length; ++j) {
                if (lottos[i] == win_nums[j]) {
                    ++same;
                    break;
                }
            }
        }

        answer[0] = 7 - (same + zero == 0 ? 1 : same + zero);
        answer[1] = 7 - (same == 0 ? 1 : same);

        return answer;
    }
}