package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 여행경로 {

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[] answer = solution(tickets);
		System.out.println(answer);
	}

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		
		Map<Integer, List<String>> map = new HashMap<>();
		
		boolean[] visit = new boolean[tickets.length];
		
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				visit[i] = true;
				bfs(map, visit);
				visit[i] = false;
			}
		}
		
		return answer;
	}

	private static void bfs(Map<Integer, List<String>> map, boolean[] visit) {
		
	}
}
