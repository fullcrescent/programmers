package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 합승_택시_요금 {

	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		int answer = solution(n, s, a, b, fares);
		System.out.println(answer);
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int[] fare : fares) {
			List<Integer> tempList;
			
			tempList = map.getOrDefault(fare[0], new ArrayList<>());
			tempList.add(fare[1]);
			map.put(fare[0], tempList);
			
			tempList = map.getOrDefault(fare[1], new ArrayList<>());
			tempList.add(fare[0]);
			map.put(fare[1], tempList);
		}
		
		
		return 0;
	}
	
}

class Path{
	Character target;
	int cost;
	int nextPoint;
	
	public Path(Character target, int cost, int nextPoint) {
		super();
		this.target = target;
		this.cost = cost;
		this.nextPoint = nextPoint;
	}
}