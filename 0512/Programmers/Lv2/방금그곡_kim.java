package study_0512;

import java.util.LinkedList;
import java.util.List;

public class Programmers_Lv2_방금그곡 {
	public static void main(String[] args) {
		String m = "CCB";
		String[] musicinfos = { "03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC" };
		String[][] music = new String[musicinfos.length][4];
		for (int i = 0; i < musicinfos.length; i++) {
			music[i] = musicinfos[i].split(",");
		}
		String answer = "(None)";
		int maxtime = 0;
		for (int i = 0; i < musicinfos.length; i++) {
			int time = 0;
			String[] start = music[i][0].split(":");
			String[] end = music[i][1].split(":");
			// 재생한 시간을 분 단위로 계산
			if (Integer.parseInt(end[1]) < Integer.parseInt(start[1])) {
				time = (Integer.parseInt(end[0]) - 1 - Integer.parseInt(start[0])) * 60
						+ (Integer.parseInt(end[1]) + 60 - Integer.parseInt(start[1]));
			} else {
				time = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60
						+ (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
			}
			StringBuilder sb = new StringBuilder();
			int index = 0;
			int length = 0;
			// 재생 시간만큼 나온 코드를 찾아서 sb에 저장한다.
			while (length != time) {
				sb.append(music[i][3].charAt(index % music[i][3].length()));
				if (music[i][3].charAt(index % music[i][3].length()) != '#') {
					length++;
				}
				index++;
			}
			// 해당 시간만큼 재생된 코드 찾았는데 바로 다음에 #이 오면 #까지 붙여준다.
			if (music[i][3].charAt(index % music[i][3].length()) == '#') { 
				sb.append("#");
			}
			if (!m.contains("#")) { // 찾고자 하는 코드에 #이 없으면
				for (int j = 1; j < sb.length(); j++) {
					if (sb.charAt(j) == '#') {
						sb.replace(j-1, j, "0"); // 재생한 길이만큼의 노래 코드의 #전에 0으로 바꿈
					}
				}
			}
			// 재생한 시간만큼의 코드에서 찾고자 하는 코드가 있을 때 재생시간이 가장 긴 음악을 정답으로 도출
			if (sb.toString().contains(m)) {				
				if (time > maxtime) {
					maxtime = time;
					answer = music[i][2];
				}
			}
		}
		System.out.println(answer);

	}

}
