package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		int answer = solution(want, number, discount);
		System.out.println(answer);
	}
	
	public static int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> countMap = new HashMap<>();
		
		for(int i=0; i<want.length; i++) {
			countMap.put(want[i], countMap.getOrDefault(want[i], 0)+number[i]);
		}
		
		int start = -1;
		int sum = Arrays.stream(number).sum();
		
		Loop :
		while(++start<discount.length-10) {
			Map<String, Integer> tempMap = new HashMap<>();
			
			for(int i=start; i<start+sum; i++) {
				String discountItem = discount[i];
				
				tempMap.put(discountItem, tempMap.getOrDefault(discountItem, 0)+1);
				
				if(tempMap.get(discountItem)>countMap.getOrDefault(discountItem, 0)) continue Loop;
			}
			
			return start+1;
		}
		
		return 0;
	}
}
