package programmers.level2;

public class 방금그곡 {

	public static void main(String[] args) {
		String m = "ABC";
		String[] musicinfos = {"12:00,12:03,HELLO,ABC", "13:00,13:05,WORLD,ABC#DEF"};
		String answer = solution(m, musicinfos);
		System.out.println(answer);
	}
	
    public static String solution(String m, String[] musicinfos) {
    	String answer = "(None)";
    	int answerTime = 0;
    	
    	StringBuffer sb = new StringBuffer();
    	
    	for(String musicinfo : musicinfos) {
    		String[] info = musicinfo.split(",");
    		
    		int playTime = (Integer.parseInt(info[1].split(":")[0])- Integer.parseInt(info[0].split(":")[0]))*60
    				+(Integer.parseInt(info[1].split(":")[1])- Integer.parseInt(info[0].split(":")[1]));
    		
    		for(int i=0; i<playTime/info[3].replaceAll("#", "").length(); i++) {
    			sb.append(info[3]);
    		}
    		
    		int index = playTime%info[3].replaceAll("#", "").length();
    		
    		for(int i=0; i<index; i++) {
    			sb.append(info[3].charAt(i));
    			if(info[3].charAt(i+1)=='#') {
    				index++;
    			}
    		}
    		
    		while(true) {
    			int temp = sb.indexOf(m);
    			if(temp>=0) {
    				if(sb.length()==temp+m.length() || sb.charAt(temp+m.length())!='#') {
    					if(playTime>answerTime) {
    						answer = info[2];
    						answerTime = playTime;
    					}
    					break;
    				}else {
    					sb.delete(0, temp+m.length());
    					continue;
    				}
    			}
    			
    			break;
    		}
    		
    		sb.delete(0, sb.length());
    	} 
    	
    	return answer;
    }
}
