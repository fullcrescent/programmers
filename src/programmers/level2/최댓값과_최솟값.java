package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 최댓값과_최솟값 {

	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		String answer = solution(s);
		System.out.println(answer);
		
		String s1 = "-1 -2 -3 -4";
		String answer1 = solution1(s1);
		System.out.println(answer1);
	}
	
	public static String solution(String s) {
		String[] temp = s.split(" ");
		Arrays.sort(temp, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
			}
		});
		
		return temp[0] + " " + temp[temp.length-1];
	}
	
	// 다른 사람의 풀이 참고
	public static String solution1(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).min().getAsInt() 
				+ " " 
				+ Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).max().getAsInt();
	}
}
