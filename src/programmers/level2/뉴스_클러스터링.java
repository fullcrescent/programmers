package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 뉴스_클러스터링 {

	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		int answer = solution(str1, str2);
		System.out.println(answer);
	}
	
	public static int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();
		
		for(int i=0; i<str1.length()-1; i++) {
			String temp = str1.substring(i, i+2);
			if(temp.matches("([a-zA-Z])*")) {
				queue1.add(temp);
			}
		}
		
		for(int i=0; i<str2.length()-1; i++) {
			String temp = str2.substring(i, i+2);
			if(temp.matches("([a-zA-Z])*")) {
				queue2.add(temp);
			}
		}
		
		int intersection = 0;
		int union = queue1.size() + queue2.size();
		
		while(!queue2.isEmpty()) {
			String temp = queue2.poll();
			
			if(queue1.contains(temp)) {
				queue1.remove(temp);
				intersection++;
				union--;
			}
		}
		
		return union==0 ? 65536 : (int) ((double)intersection/union*65536);
	}

}
