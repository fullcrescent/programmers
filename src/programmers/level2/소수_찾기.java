package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 소수_찾기 {
	public static void main(String args[]) {
		String numbers = "71";
		int answer = solution(numbers);
		System.out.println(answer);
	}

	public static int solution(String numbers) {
		for(int i=0; i<numbers.length(); i++) {
			permutaion(numbers, new boolean[numbers.length()], "", 0, i+1);
		}
		
		return answer;
	}

	private static int answer = 0;
	private static Queue<Integer> queue = new LinkedList<>();
	
	private static void permutaion(String numbers, boolean[] visit, String value, int index, int count) {
		if(index == count) {
			if(!queue.contains(Integer.valueOf(value)) && verification(value)) {
				answer++;
				queue.add(Integer.valueOf(value));
			}
			return;
		}
		
		for(int i=0; i<numbers.length(); i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			permutaion(numbers, visit, value+String.valueOf(numbers.charAt(i)), index+1, count);
			visit[i] = false;
		}
	}

	private static boolean verification(String value) {
		int number = Integer.valueOf(value);
		if(number<2	) {
			return false;
		}
		
		int length = (int) Math.sqrt(number);
		
		boolean[] visit= new boolean[(int) Math.sqrt(Integer.valueOf(value))+1];
		
		for(int i=2; i <= length; i++) {
			if(visit[i]) continue;
			
			if(number%i == 0) {
				return false;
			}
			
			for(int j=i; j<= length; j=j+i) {
				visit[j] = true;
			}
		}
		
		return true;
	}
}
