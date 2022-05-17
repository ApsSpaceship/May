import java.util.HashSet;

class Solution {
    static int x;
    static int y;
    static HashSet<String> set;
    public int solution(String dirs) {
        x = 0;
        y = 0;
        set = new HashSet<>();  
        for(int i = 0; i < dirs.length(); i++) {
            move(dirs.charAt(i));
        }
        return set.size()/2;
    }
    public void move(char c) {
        StringBuilder sb = new StringBuilder();
        String from = "";
        switch(c) {
            case 'U':
                if(checkRange(x, y-1)){
                    sb.append(x).append(y);
                    from = sb.toString();
                    sb.setLength(0);
                    y--;
                    set.add(sb.append(from).append(x).append(y).toString());
                    sb.setLength(0);
                    set.add(sb.append(x).append(y).append(from).toString());
                }
                break;
            case 'D':
                if(checkRange(x, y+1)){
                    sb.append(x).append(y);
                    from = sb.toString();
                    sb.setLength(0);
                    y++;
                    set.add(sb.append(from).append(x).append(y).toString());
                    sb.setLength(0);
                    set.add(sb.append(x).append(y).append(from).toString());
                }
                break;
            case 'L':
                if(checkRange(x-1, y)){
                    sb.append(x).append(y);
                    from = sb.toString();
                    sb.setLength(0);
                    x--; 
                    set.add(sb.append(from).append(x).append(y).toString());
                    sb.setLength(0);
                    set.add(sb.append(x).append(y).append(from).toString());
                }     
                break;
            case 'R' :
                if(checkRange(x+1, y)){
                    sb.append(x).append(y);
                    from = sb.toString();
                    sb.setLength(0);
                    x++; 
                    set.add(sb.append(from).append(x).append(y).toString());
                    sb.setLength(0);
                    set.add(sb.append(x).append(y).append(from).toString());
                }
                break;                
        }
    }
    public boolean checkRange(int x, int y) {
        if(x > 5 || x < -5 || y > 5 || y < -5)
            return false;
        return true;
    }
}