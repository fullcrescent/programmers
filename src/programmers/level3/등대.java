package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 등대 {

	public static void main(String[] args) {
		int n = 8;
		int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
		int answer = solution(n, lighthouse);
		System.out.println(answer);
	}
	
	public static int solution(int n, int[][] lighthouse) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int[] temp : lighthouse) {
			List<Integer> tempList;
			
			tempList = map.getOrDefault(temp[0], new ArrayList<>());
			tempList.add(temp[1]);
			map.put(temp[0], tempList);
			
			tempList = map.getOrDefault(temp[1], new ArrayList<>());
			tempList.add(temp[0]);
			map.put(temp[1], tempList);
		}
		
		return n;
	}
}
