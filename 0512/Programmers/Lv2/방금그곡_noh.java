class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");

        int musicTime = 0;
        for (int i = 0; i < musicinfos.length; ++i) {
            String[] splitt = musicinfos[i].split(",");

            splitt[3] = splitt[3].replace("C#", "c");
            splitt[3] = splitt[3].replace("D#", "d");
            splitt[3] = splitt[3].replace("F#", "f");
            splitt[3] = splitt[3].replace("G#", "g");
            splitt[3] = splitt[3].replace("A#", "a");

            int playTime = timeToInt(splitt[0], splitt[1]);
            System.out.println(playTime);
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            for (int j = 0; j < playTime; ++j) {
                sb.append(splitt[3].charAt((idx++) % splitt[3].length()));
            }

            if (sb.indexOf(m) != -1) {
                if (playTime > musicTime) {
                    musicTime = playTime;
                    answer = splitt[2];
                }
            }
        }

        return answer;
    }

    static int timeToInt(String startTime, String endTime) {
        return Integer.parseInt(endTime.substring(0, 2)) * 60 + Integer.parseInt(endTime.substring(3, 5))
                - Integer.parseInt(startTime.substring(0, 2)) * 60 - Integer.parseInt(startTime.substring(3, 5));
    }
}