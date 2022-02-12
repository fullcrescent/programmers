package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 최댓값과_최솟값 {

	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		String answer = solution(s);
		System.out.println(answer);
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
}
