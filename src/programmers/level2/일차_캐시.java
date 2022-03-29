package programmers.level2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 일차_캐시 {
	public static void main(String[] args) {
		int cachSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		int answer = solution(cachSize, cities);
		System.out.println(answer);
		
		int cachSize1 = 3;
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		int answer1 = solution1(cachSize1, cities1);
		System.out.println(answer1);
	}
	
	public static int solution(int cacheSize, String[] cities) {
		List<String> list = new LinkedList<>();
		
		int answer = 0 ;
		int cacheHit = 1;
		int cacheMiss = 5;
		
		for(String temp : cities) {
			temp = temp.toLowerCase();
			
			if(list.remove(temp)) {
				answer += cacheHit;
				list.add(0, temp);
			}else {
				answer += cacheMiss;
				list.add(0, temp);
				
				if(list.size()>cacheSize) {
					list.remove(list.size()-1);
				}
			}
		}
		
        return answer;
    }
	
	// 다른 사람의 풀이 참고
	public static int solution1(int cacheSize, String[] cities) {
		Stack<String> stack = new Stack<>();
		
		int answer = 0 ;
		int cacheHit = 1;
		int cacheMiss = 5;
		
		for(String temp : cities) {
			temp = temp.toLowerCase();
			
			if(stack.remove(temp)) {
				answer += cacheHit;
				stack.add(temp);
			}else {
				answer += cacheMiss;
				stack.add(temp);
				
				if(stack.size()>cacheSize) {
					stack.remove(0);
				}
			}
		}
		
        return answer;
    }
}
