package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int answer = solution(clothes);
		System.out.println(answer);
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

}
