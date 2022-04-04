package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
		
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] answer1 = solution1(s1);
		System.out.println(Arrays.toString(answer1));
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
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(String s) {
		Map<String, Integer> map = new HashMap<>();

		String[] numbers = s.replace("{", "").replace("}", "").split(",");
		
		for(String n : numbers) {
			map.put(n, map.getOrDefault(n, 0)+1);
		}
		
		int length = map.size();
		int[] answer = new int[length];
		
		for(String key : map.keySet()) {
			answer[length-map.get(key)] = Integer.parseInt(key);
		}
		
		return answer;
	}
}
