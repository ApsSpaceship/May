import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class Solution {
	static Pattern p = Pattern.compile("[0-9]+"); // 숫자 정규표현식
	static Matcher m;
	static List<File> list = new ArrayList<>();

	static class File implements Comparable<File> {
		String header;
		String number;
		String tail;

		@Override
		public int compareTo(File o) {
			int sCom = this.header.compareToIgnoreCase(o.header);
			if (sCom == 0) // 헤더 같으면 숫자 비교
				return Integer.parseInt(this.number) - Integer.parseInt(o.number);
			return sCom;
		}
	}

	public String[] solution(String[] files) {
		int fLen = files.length;
		String[] answer = new String[fLen];
		for (int i = 0; i < fLen; i++)
			findNum(files[i]);
		Collections.sort(list); // 정렬
		for (int i = 0; i < fLen; i++) {
			File file = list.get(i);
			answer[i] = file.header + file.number + file.tail;
		}

		return answer;
	}

	static void findNum(String str) {
		File file = new File();
		m = p.matcher(str); // 숫자 찾아서
		m.find();
		int start = m.start();
		int end = m.end();
		if (end - start > 5) // 숫자는 5개까지
			end = start + 5;

		file.header = str.substring(0, start); // 숫자 앞까지
		file.number = str.substring(start, end); // 숫자
		file.tail = str.substring(end); // 숫자 뒤부터
		list.add(file);
	}

}