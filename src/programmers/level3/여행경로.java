package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 여행경로 {

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] answer = solution(tickets);
		System.out.println(Arrays.toString(answer));
	}

	public static String[] solution(String[][] tickets) {
		boolean[] visit = new boolean[tickets.length];
		
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				visit[i] = true;
				
				List<String> tempList = new ArrayList<>();
				tempList.add(tickets[i][0]);
				tempList.add(tickets[i][1]);
				
				bfs(tickets, tempList, visit);
				
				visit[i] = false;
			}
		}
		
		List<String> answer = null;
		
		for(Integer temp : map.keySet()) {
			List<String> tempList = map.get(temp);
			
			if(answer==null) {
				answer = tempList;
			}else {
				for(int i=0; i<tickets.length; i++) {
					if(tempList.get(i).compareTo(answer.get(i))<0) {
						answer = tempList;
						break;
					}else if(tempList.get(i).compareTo(answer.get(i))==0) {
						continue;
					}else {
						break;
					}
				}
			}
		}
		
		return answer.toArray(new String[tickets.length]);
	}
	
	static Map<Integer, List<String>> map = new HashMap<>();
	static int index = 0;
	
	private static void bfs(String[][] tickets, List<String> list, boolean[] visit) {
		if(validate(visit)) {
			List<String> tempList = new ArrayList<>(list);
			map.put(index++, tempList);
			return;
		}
		
		String temp = list.get(list.size()-1);
		
		for(int i=0; i<tickets.length; i++) {
			if(visit[i]) continue;
			
			if(temp.equals(tickets[i][0])) {
				visit[i] = true;
				list.add(tickets[i][1]);
				bfs(tickets, list, visit);
				list.remove(list.size()-1);
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

