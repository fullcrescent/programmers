package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 여행경로 {

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[] answer = solution(tickets);
		System.out.println(Arrays.toString(answer));
	}

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		
		boolean[] visit = new boolean[tickets.length];
		
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				visit[i] = true;
				
				List<String> tempList = new ArrayList<>();
				tempList.add(tickets[i][0]);
				tempList.add(tickets[i][1]);
				
				bfs(tickets, tempList, visit, i);
				map.put(i, tempList);
				
				visit[i] = false;
			}
		}
		
		return answer;
	}
	
	static Map<Integer, List<String>> map = new HashMap<>();
	
	private static void bfs(String[][] tickets, List<String> list, boolean[] visit, int index) {
		if(validate(visit)) {
			map.put(index, list);
		}
		
		String temp = list.get(list.size()-1);
		
		for(int i=0; i<tickets.length; i++) {
			if(visit[i]) continue;
			
			if(temp.equals(tickets[i][1])) {
				visit[i] = true;
				list.add(tickets[i][0]);
				bfs(tickets, list, visit, index);
				visit[i] = false;
			}
		}
	}

	private static boolean validate(boolean[] visit) {
		for(int i=0; i<visit.length; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		
		return true;
	}
}

