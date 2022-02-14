package programmers.level2;

public class JadenCase_문자열_만들기 {

	public static void main(String[] args) {
		String s = "3people  UnFollowed me  ";
		String answer = solution(s);
		System.out.println(answer);
		
		String s1 = "3people  UnFollowed me  ";
		String answer1 = solution1(s1);
		System.out.println(answer1);
	}
	
	public static String solution(String s) {
		s = s.toLowerCase();
		String[] sArray = s.split(" ");
		
		int index = 0;
		
		for(String temp : sArray) {
			if(!temp.equals("") && temp.charAt(0)>=97 && temp.charAt(0)<=122) {
				sArray[index] = (char)(temp.charAt(0)-32) + temp.substring(1);
			}
			index++;
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(String temp : sArray) {
			sb.append(temp + " ");
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		if(s.length()!=sb.length()) {
			int temp =s.length()-sb.length();
			while(temp-->0) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	// 다른 사람의 풀이 참고
	public static String solution1(String s) {
		StringBuffer sb = new StringBuffer();
		boolean[] flag = new boolean[1];
		flag[0] = true;
		
		s.toLowerCase().chars().forEach(i -> {
			sb.append(flag[0] ? (char)Character.toUpperCase(i) : (char)(i));
			flag[0] = i==' ' ? true : false;
		});	
		
		return sb.toString();
	}
	
}
