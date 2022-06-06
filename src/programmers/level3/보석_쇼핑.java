package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 보석_쇼핑 {

	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA", "SAPPHIRE", "EMERALD", "RUBY"};
		int[] answer = solution(gems);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		
		Map<String, List<Integer>> map = new HashMap<>();
		
		for(int i=0; i<gems.length; i++) {
			List<Integer> temp  = map.getOrDefault(gems[i], new ArrayList<>());
			temp.add(i);
			
			map.put(gems[i], temp);
		}
		
		int min = gems.length;
		int max = 0;
		boolean flag = true;
		
		for(int i=0; i<=gems.length-map.size(); i++) {
			if(flag) {
				for(String temp : map.keySet()) {
					if(map.get(temp).size()>0) {
						max = Math.max(max, map.get(temp).get(0));
					}
				}
			}
			
			List<Integer> temp = map.get(gems[i]);
			int tempValue = temp.get(0);
			temp.remove(0);
			
			while(temp.size()>0 && i<max && ++tempValue==temp.get(0)) {
				i++;
				temp.remove(0);
			}
			
			if(min > max-i) {
				min = max-i;
				answer[0] = i+1;
				answer[1] = max+1;
			}
			
			if(temp.size()==0) {
				break;
			}else if(temp.get(0)<max) {
				flag = false;
			}else {
				flag = true;
			}
		}
		
		return answer;
	}
}
