package programmers.level2;

import java.util.Arrays;

public class 이진_변환_반복하기 {

	public static void main(String[] args) {
		String s = "110010101001";
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
	}
	
    public static int[] solution(String s) {
    	int[] answer = new int[2];
    	
    	while(s.length()!=1) {
    		String temp = s.replace("0", "");
    		answer[1] += s.length() - temp.length();
    		
    		s = Integer.toBinaryString(temp.length());
    		
    		answer[0]++;
    	}
    	
    	return answer;
    }
}
