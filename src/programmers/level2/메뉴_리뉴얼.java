package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 메뉴_리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] answer = solution(orders, course);
		System.out.println(Arrays.toString(answer));
	}
	
	public static String[] solution(String[] orders, int[] course) {
		List<String> list =new ArrayList<>();
		
		for(int i=0; i<orders.length; i++) {
			for(int j=0; j<course.length; j++) {
				dfs(orders[i], course[j], 0, "", 0);
			}
		}
		
		Iterator<String> iterator = mapCount.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			
			if(mapMaxCount.get(key.length())>1 && mapCount.get(key)==mapMaxCount.get(key.length())) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
		
		return list.toArray(new String[0]);
	}
	
	static Map<Integer, Integer> mapMaxCount = new HashMap<>(); 
	static Map<String, Integer> mapCount = new HashMap<>(); 
			
	private static void dfs(String order, int course, int index, String temp, int count) {
		for(int i=index; i<order.length(); i++) {
			String key = sort(temp, String.valueOf(order.charAt(i)));
			if(course-1>count) {
				dfs(order, course, i+1, key, count+1);
			}else if(course-1==count) {
				if(mapCount.get(key)==null) {
					mapCount.put(key, 1);
					if(mapMaxCount.get(course)==null) {
						mapMaxCount.put(course, 1);
					}
				}else {
					mapCount.put(key, mapCount.get(key)+1);
					if(mapMaxCount.get(course)<mapCount.get(key)) {
						mapMaxCount.put(course, mapCount.get(key));
					}
				}
			}
		}
	}

	private static String sort(String s1, String s2) {
		char[] charArray = (s1+s2).toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}
