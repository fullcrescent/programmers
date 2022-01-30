package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class n2_배열_자르기 {

	public static void main(String[] args) {
		int n = 4;
		long left = 7;
		long right = 14;
		int[] answer = solution(n, left, right);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n, long left, long right) {
		List<Integer> list = new LinkedList<>();
		
		for(long i=left; i<right+1; i++) {
			int quotient = (int) (i/n); 
			int remainder = (int) (i%n);
			
			if(quotient>remainder) {
				list.add(quotient+1);
			}else {
				list.add(remainder+1);
			}
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
