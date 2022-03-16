package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class 메뉴_리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,5};
		String[] answer = solution(orders, course);
		System.out.println(Arrays.toString(answer));
		
		String[] orders1 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course1 = {2,3,5};
		String[] answer1 = solution1(orders1, course1);
		System.out.println(Arrays.toString(answer1));
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
	
	static Map<Integer, Integer> mapMaxCount = new HashMap<>(); 	// 각 길이별 최대 등장 횟수
	static Map<String, Integer> mapCount = new HashMap<>(); 		// 모든 문자 등장 횟수
			
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
	
	// 다른 사람의 풀이 참고
	public static String[] solution1(String[] orders, int[] course) {
		Queue<String> queue = new PriorityQueue<>();
		
		for(int i=0; i<course.length; i++) {
			max = 0;
			map = new HashMap<>();
			for(int j=0; j<orders.length; j++) {
				dfs1(orders[j], course[i], "", 0, 0);
			}
			for(String key : map.keySet()) {
				if(map.get(key)==max&&max>1) {
					queue.add(key);
				}
			}
		}
		
//		return Arrays.stream(queue.toArray()).toArray(String[]::new);	우선순위 큐의 경우 poll 할 때 위치를 찾아가서 값을 반환하므로 toArray로 받으면 배열순서 어긋남.  
		
		String[] answer = new String[queue.size()];
		int index = 0;
		while(!queue.isEmpty()) {
			answer[index++] = queue.poll();
		}
		
		return answer;
	}
	
	static int max;
	static Map<String, Integer> map; 
	
	private static void dfs1(String order, int course, String temp, int index, int count) {
		if(course==count) {
			char[] key = temp.toCharArray();
			Arrays.sort(key);
			map.put(new String(key), map.getOrDefault(new String(key), 0)+1);
			max = Math.max(max, map.get(new String(key)));
			return;
		}
		
		for(int i=index; i<order.length(); i++) {
			dfs1(order, course, temp+String.valueOf(order.charAt(i)), i+1, count+1);
		}
	}
}
