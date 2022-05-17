package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class N으로_표현 {

	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		int answer = solution(N, number);
		System.out.println(answer);
		
		int N1 = 5;
		int number1 = 12;
		int answer1 = solution1(N1, number1);
		System.out.println(answer1);
	}
	
	public static int solution(int N, int number) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		List<Integer> tempList = new ArrayList<>();
		tempList.add(N);
		
		map.put(1, tempList);
		int answer = 1;
		
		while(!tempList.contains(number)) {
			if(answer++>8) {
				answer = -1;
				break;
			}
			
			tempList = new ArrayList<>();
			
			for(int i=1; i<=answer/2; i++) {
				dp(tempList, map.get(answer-i), map.get(i), N, answer);
			}
			
			map.put(answer, tempList);
		}
		
		return answer;
	}

	private static void dp(List<Integer> tempList, List<Integer> list1, List<Integer> list2, int N, int length) {
		for(int temp1 : list1) {
			for(int temp2 : list2) {
				tempList.add(temp1+temp2);
				tempList.add(temp1-temp2);
				tempList.add(temp2-temp1);
				tempList.add(temp1*temp2);
				if(temp1!=0) {
					tempList.add(temp2/temp1);
				}
				if(temp2!=0) {
					tempList.add(temp1/temp2);
				}
			}
		}
		
		int temp = 0;
		for(int i=0; i<length; i++) {
			temp += N*Math.pow(10, i);
		}
		tempList.add(temp);
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int N, int number) {
		int answer = -1;
		int max = 8;
		
		List<Set<Integer>> list = new ArrayList<>();
		
		int temp = N;
		
		list.add(null);
		for(int i=0; i<max; i++) {
			Set<Integer> tempSet = new HashSet<>();
			tempSet.add(temp);
			list.add(tempSet);
			temp = temp*10+N;
		}
		
		for(int i=1; i<=max; i++) {
			Set<Integer> tempSet = list.get(i);
			for(int j=1; j<i; j++) {
				for(Integer prev : list.get(j)) {
					for(Integer post : list.get(i-j)) {
						tempSet.add(prev+post);
						tempSet.add(prev-post);
						tempSet.add(prev*post);
						if(post!=0)	tempSet.add(prev/post);
						if(prev!=0)	tempSet.add(post/prev);
					}
				}
			}
			if(tempSet.contains(number)) {
				answer = i;
				break;
			}
		}
		
		return answer;
	}
}
