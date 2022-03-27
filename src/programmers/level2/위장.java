package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int answer = solution(clothes);
		System.out.println(answer);
		
		String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int answer1 = solution1(clothes1);
		System.out.println(answer1);
	}

	public static int solution(String[][] clothes) {
		Map<String, List<String>> map = new HashMap<>();
		
		for(String[] temp : clothes) {
			String key = temp[1];
			String value = temp[0];
			
			if(map.get(key)==null) {
				List<String> tempList = new ArrayList<>();
				tempList.add(value);
				map.put(key, tempList);
			}else {
				map.get(key).add(value);
			}
		}
		
		Iterator<String> iterator = map.keySet().iterator();
		
		int answer=0; 
		answer = map.get(iterator.next()).size()+1;
		
		while(iterator.hasNext()) {
			answer *= map.get(iterator.next()).size()+1;
		}
		
		answer--;
		
		return answer;
	}

	// 다른 사람의 풀이 참고
	public static int solution1(String[][] clothes) {
		return Arrays.stream(clothes)
				.collect(groupingBy(i -> i[1], mapping(i -> i[0], counting())))
				.values()
				.stream()
				.collect(reducing(1L, (x,y) -> x*(y+1))).intValue() -1;
	}
}
