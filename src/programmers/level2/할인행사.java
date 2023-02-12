package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

	public static void main(String[] args) {
		String[] want = {"banana"};
		int[] number = {10};
		String[] discount = {"apple", "banana","banana","banana","banana","banana","banana","banana","banana","banana","banana","banana","banana"};
		int answer = solution(want, number, discount);
		System.out.println(answer);
	}
	
	public static int solution(String[] want, int[] number, String[] discount) {
		int count = 0;
		int length = 10;
		Map<String, Integer> wantMap = new HashMap<>();
		Map<String, Integer> discountMap = new HashMap<>();

		for(int i=0; i<want.length; i++){
			wantMap.put(want[i], number[i]);
		}

		for(int i=0; i<length; i++){
			discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0)+1);
		}

		if(compare(wantMap, discountMap)) count++;

		for(int i=0; i<discount.length-10; i++){
			discountMap.put(discount[i], discountMap.get(discount[i])-1);
			discountMap.put(discount[i+10], discountMap.getOrDefault(discount[i+10], 0)+1);

			if(compare(wantMap, discountMap)) count++;
		}

		return count;
	}

	private static boolean compare(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
		for(String key : wantMap.keySet()){
			if(!wantMap.get(key).equals(discountMap.get(key)))	return false;
		}

		return true;
	}
}
