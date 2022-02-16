package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class N개의_최소공배수 {

	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		int answer = solution(arr);
		System.out.println(answer);
		
		int[] arr1 = {2,6,8,14};
		int answer1 = solution1(arr1);
		System.out.println(answer1);
	}

	public static int solution(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int temp : arr) {
			Map<Integer, Integer> tempMap = new HashMap<>();
			int index = 2;
			while(temp!=1) {
				if(temp%index==0) {
					temp /= index;
					if(tempMap.get(index)==null) {
						tempMap.put(index, 1);
					}else {
						tempMap.put(index, tempMap.get(index)+1);
					}
				}else {
					index++;
				}
			}
			
			for(int i : tempMap.keySet()) {
				if(map.get(i)==null||map.get(i)<tempMap.get(i)) {
					map.put(i, tempMap.get(i));
				}
			}
		}
		
		int answer = 1;
		
		for(int i : map.keySet()) {
			answer *= Math.pow(i, map.get(i));
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[] arr) {
		int answer = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			answer = answer*arr[i]/(answer>arr[i] ? gcd(answer, arr[i]) : gcd(arr[i], answer));
		}
		
		return answer;
	}
	
	public static int gcd(int big, int small) {
		if(small==0) return big;
		return gcd(small, big%small);
	}
}
