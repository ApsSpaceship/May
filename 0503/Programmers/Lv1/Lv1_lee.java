class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 이미 당첨인 경우로 초기화
        int[] answer = {1, 1};
        // 당첨 번호와 같은 번호 개수
        int cnt = 0;
        // 알아볼 수 없는 번호 개수
        int zero_cnt = 0;
        // 나의 로또 번호 배열 반복
        for(int i = 0; i < 6; i++) {
            // 알아볼 수 없는 번호 개수 증가
            if(lottos[i] == 0)
                zero_cnt++;
            else { 
                // 당첨 번호 배열 반복
                for(int j = 0; j < 6; j++) {
                    // 같으면 개수 증가 후 빠져나오기
                    if(lottos[i] == win_nums[j]){
                        cnt++;
                        break;
                    }    
                }
            }
        }
        // 이미 당첨인 경우
        if(zero_cnt == 0 && cnt == 6)
            return answer;
        // 전부 불일치인 경우
        else if(zero_cnt == 0 && cnt == 0){
            answer[0] = 6;
            answer[1] = 6;
            return answer;
        }      
        // 전부 0인 경우
        else if(zero_cnt == 6) {
            answer[1] = 6;
            return answer;
        }else {
            // 나머지는 등수를 구해준다.
            answer[0] = 7 - (zero_cnt + cnt);
            answer[1] = 7 - cnt;
        }
        return answer;
    }
}
