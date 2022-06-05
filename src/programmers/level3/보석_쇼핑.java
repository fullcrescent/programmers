package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 보석_쇼핑 {

	public static void main(String[] args) {
		String[] gems = {"XYZ", "XYZ", "XYZ"};
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
		
		Loop1 :
		for(int i=0; i<gems.length-map.size(); i++) {
			int max = 0;
			
			for(String temp : map.keySet()) {
				if(map.get(temp).size()>0) {
					max = Math.max(max, map.get(temp).get(0));
				}else {
					break Loop1;
				}
			}
			
			List<Integer> temp = map.get(gems[i]);
			int tempValue = temp.get(0);
			temp.remove(0);
			
			while(temp.size()>0 && ++tempValue==temp.get(0)) {
				i++;
				temp.remove(0);
			}
			
			if(min > max-i) {
				min = max-i;
				answer[0] = i+1;
				answer[1] = max+1;
			}
			
		}
		
		return answer;
	}
}
