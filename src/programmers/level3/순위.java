package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 순위 {

	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int answer = solution(n, results);
		System.out.println(answer);
	}
	
	public static int solution(int n, int[][] results) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int[] temp : results) {
			map.put(temp[0], map.getOrDefault(temp[0], 0)+1);
			map.put(temp[1], map.getOrDefault(temp[1], 0));
		}
		
		List<Integer> list = new ArrayList<>(map.keySet());
		list.sort((i1, i2) -> -Integer.compare(map.get(i1), map.get(i2)));
		
		int tempValue = list.get(0);
		
		for(int i=1; i<list.size(); i++) {
			if(tempValue==map.get(list.get(i))) {
				answer++;
			}else {
				tempValue = map.get(list.get(i));
			}
		}
		
		return answer;
	}
}
