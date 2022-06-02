public int solution(int[] absolutes, boolean[] signs) {
    int answer = 0;
    int len = signs.length;
    for (int i = 0; i < len; i++) {
        if (signs[i]) // 양수면 더하고
            answer += absolutes[i];
        else // 음수면 빼기
            answer -= absolutes[i];
    }

    return answer;
}
