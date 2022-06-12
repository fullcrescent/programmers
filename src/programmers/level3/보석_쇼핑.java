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
		
		String[] gems1 = {"XYZ", "XYZ", "XYZ"};
		int[] answer1 = solution1(gems1);
		System.out.println(Arrays.toString(answer1));
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
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(String[] gems) {
		int[] answer = new int[2];
		
		Map<String, List<Integer>> map = new HashMap<>();
		
		for(int i=0; i<gems.length; i++) {
			List<Integer> temp  = map.getOrDefault(gems[i], new ArrayList<>());
			temp.add(i);
			
			map.put(gems[i], temp);
		}
		
		int min = gems.length;
		int max = 0;
		
		List<Integer> temp = map.get(gems[0]);
		
		for(int i=0; i<=gems.length-map.size(); i++) {
			if(temp.get(0)>=max) {
				for(String key : map.keySet()) {
					if(map.get(key).size()>0) {
						max = Math.max(max, map.get(key).get(0));
					}
				}
			}
			
			temp = map.get(gems[i]);
			int tempValue = temp.remove(0);
			
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
			}
		}
		
		return answer;
	}
}
