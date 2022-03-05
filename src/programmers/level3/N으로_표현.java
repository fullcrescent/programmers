package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N으로_표현 {

	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		int answer = solution(N, number);
		System.out.println(answer);
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
}
