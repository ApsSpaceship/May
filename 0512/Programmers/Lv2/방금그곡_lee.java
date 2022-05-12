class Solution {
	static String answer;
	static int ansTime;

	public String solution(String m, String[] musicinfos) {
		// 네오가 찾으려는 음악의 제목
		answer = "";
        // 네오가 찾으려는 음악의 재생 시간
		ansTime = 0;
        // 네오가 기억한 멜로디를 확인할 문자열 만들기용
		StringBuilder sb = new StringBuilder();
		// 해당 음악 존재 여부 판단
        boolean flag = false;
		for (int i = 0; i < musicinfos.length; i++) {
			String[] info = musicinfos[i].split(",");
			int time = calcTime(info[0], info[1]); // 걸린 시간 구하기
			int t = time; // 반복문 조건용
			int idx = 0; // 문자열의 인덱스
			int len = info[3].length(); // 음악의 길이
            // 시간 동안 재생되는 음악의 형태
			while (t != 0) {
                // 음악의 길이까지 다 돌았으면 다시 처음부터
				if (idx == len)
					idx = 0;
                // 문자열에 음악의 현재 인덱스 번호 문자 +
				sb.append(info[3].charAt(idx++));
                // 다시 한번 인덱스 확인
                if (idx == len)
					idx = 0;
                // 뒤 인덱스가 #인 경우 붙여주기
				if (info[3].charAt(idx) == '#')
					sb.append(info[3].charAt(idx++));
                // 시간 1분 소요
				t--;
			}
            // 현재 만들어진 문자열
            String str = sb.toString();
            // contains를 사용하기 위해 m에 #이 붙은 경우를 고려
            // "" 로 없애면, 뒤 문자와 합쳐지면서 m이 생겨날 수 있으므로,
            // 쓰이지 않는 H로 변경
            str = str.replace(m+"#", "H");
            // m 멜로디가 포함되어있는지 확인
			if (str.contains(m)){
                // 포함되어있으면, 갱신 
                updateAns(time, info[2]);
                flag = true;
            }
			sb.setLength(0); // 초기화
		}
        // 해당하는 음악 없을 때 출력,
        if(!flag)
            answer = "(None)";
		return answer;
	}
    // 시간 구하기 ( 분 )
    private int calcTime(String st, String ed) {
		int time = 0;
		String[] timeInfo = st.split(":");
		int stH = Integer.parseInt(timeInfo[0]);
		int stM = Integer.parseInt(timeInfo[1]);
		timeInfo = ed.split(":");
		int edH = Integer.parseInt(timeInfo[0]);
		int edM = Integer.parseInt(timeInfo[1]);
		if (stM <= edM) {
			time += (edM - stM) + (edH - stH) * 60;
		} else {
			stH += 1;
			time += edM + (60 - stM) + (edH - stH) * 60;
		}
		return time;
	}
    // 값 갱신하기
	private void updateAns(int currTime, String title) {
        // 현재까지의 해당하는 음악 중 재생시간이 가장 긴 것과 이번 음악의 재생시간 비교하여,
        // 더 긴 것으로 갱신 ( 같으면 먼저 입력한 것 이므로 갱신 X)
		if (currTime > ansTime) {
			answer = title;
			ansTime = currTime;
		}
	}
}