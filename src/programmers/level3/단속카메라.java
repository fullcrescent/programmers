package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 단속카메라 {

	public static void main(String[] args) {
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		int answer = solution(routes);
		System.out.println(answer);
	}
	
	public static int solution(int[][] routes) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int[] temp : routes) {
			for(int i=temp[0]; i<=temp[1]; i++) {
				map.put(i, map.getOrDefault(i, 0)+1);
			}
		}
		
		List<Integer> list = new ArrayList<>(map.keySet());
		
		Collections.sort(list, new Comparator<Integer>(){
			public int compare(Integer s1, Integer s2) {
				return -Integer.compare(map.get(s1), map.get(s2));
			}
		});
		
		int answer = 0;
		int count = routes.length;
		
		
		
		return 0;
	}
}
