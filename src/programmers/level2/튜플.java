package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(String s) {
		String[] numbers = s.replace("{", "").replace("}", "").split(",");
		
		int length = (int) s.chars().filter(c->c=='{').count()-1;
		int[] answer = new int[length];
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String n : numbers) {
			if(map.get(n)==null) {
				map.put(n, 1);
			}else {
				map.put(n, map.get(n)+1);
			}
		}
		
		Iterator<String> iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			answer[length-map.get(key)] = Integer.parseInt(key);
		}
		
		return answer;
	}

}
