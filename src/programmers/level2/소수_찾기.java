package programmers.level2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 소수_찾기 {
	public static void main(String args[]) {
		String numbers = "011";
		int answer = solution(numbers);
		System.out.println(answer);
		
		String numbers1 = "011";
		int answer1 = solution1(numbers1);
		System.out.println(answer1);
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
	
	public static int solution1(String numbers) {
		int answer1 = 0;
		Set<Integer> set = new HashSet<>();
		
		permutaion1("", numbers, set);
		
		Iterator<Integer> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			if(verification1(iterator.next())) {
				answer1++;
			}
		}
		
		return answer1;
	}
	
	private static void permutaion1(String temp, String numbers, Set<Integer> set) {
		if(numbers.length() == 0) {
			if(!temp.equals("")) {
				set.add(Integer.valueOf(temp));
			}
		}else {
			for(int i=0; i<numbers.length(); i++) {
				permutaion1(temp+numbers.charAt(i), numbers.substring(0,i) + numbers.substring(i+1, numbers.length()), set);
				permutaion1(temp, numbers.substring(0,i) + numbers.substring(i+1, numbers.length()), set);
			}
		}
	}
	
	private static boolean verification1(int number) {
		if(number<2	) {
			return false;
		}
		
		int length = (int) Math.sqrt(number);
		
		boolean[] visit= new boolean[(int) Math.sqrt(number)+1];
		
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
