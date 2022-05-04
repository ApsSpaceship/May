import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, (o1, o2) -> {
            // 스트링으로 변환
            String str1 = o1;
            String str2 = o2;

            // 소문자로 바꿔서 비교
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            // str1의 넘버의 시작과 끝 인덱스 찾기
            int idx1 = -1;// 시작 인덱스
            int idx2 = -1;// 끝 인덱스
            for (int i = 0; i < str1.length(); ++i)
                if ('0' <= str1.charAt(i) && str1.charAt(i) <= '9') {
                    if (idx1 == -1) {
                        idx1 = i;
                        idx2 = i;
                    } else if (idx2 == i - 1)
                        idx2 = i;
                }
            // str1을 찾은 인덱스로 나누기
            String head1 = str1.substring(0, idx1);
            String number1 = str1.substring(idx1, idx2 + 1);

            // str2도 마찬가지로 진행
            idx1 = -1;
            idx2 = -1;
            for (int i = 0; i < str2.length(); ++i)
                if ('0' <= str2.charAt(i) && str2.charAt(i) <= '9') {
                    if (idx1 == -1) {
                        idx1 = i;
                        idx2 = i;
                    } else if (idx2 == i - 1)
                        idx2 = i;
                }
            String head2 = str2.substring(0, idx1);
            String number2 = str2.substring(idx1, idx2 + 1);

            // 헤드가 같으면 넘버로 비교
            if (head1.equals(head2)) {
                return Integer.parseInt(number1) - Integer.parseInt(number2);
            }
            // 헤드가 다르면 헤드로 비교
            return head1.compareTo(head2);
        });

        answer = files;
        return answer;
    }
}