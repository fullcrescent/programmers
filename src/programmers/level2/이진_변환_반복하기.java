package programmers.level2;

import java.util.Arrays;

public class 이진_변환_반복하기 {

	public static void main(String[] args) {
		String s = "110010101001";
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
		
		String s1 = "110010101001";
		int[] answer1 = solution1(s1);
		System.out.println(Arrays.toString(answer1));
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
    
    // 다른 사람의 풀이 참고 - 변경X
    public static int[] solution1(String s) {
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
