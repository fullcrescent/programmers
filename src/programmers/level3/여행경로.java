package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class 여행경로 {

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] answer = solution(tickets);
		System.out.println(Arrays.toString(answer));
		
		String[][] tickets1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] answer1 = solution1(tickets1);
		System.out.println(Arrays.toString(answer1));
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
	
	// 다른 사람의 풀이 참고
	public static String[] solution1(String[][] tickets) {
		result = new ArrayList<>();
		
		boolean[] visit = new boolean[tickets.length];
		
		Stack<String> stack = new Stack<>();
		stack.push("ICN");
		
		dfs(tickets, visit, stack, 0);
		
		if(result.size()>0) {
			Collections.sort(result, (i1, i2) -> {
				for(int i=0; i<i1.size(); i++) {
					if(!i1.get(i).equals(i2.get(i))) return i1.get(i).compareTo(i2.get(i));
				}
				
				return 0;
			});
		}
		
		return result.get(0).toArray(new String[tickets.length]);
	}

	static List<Stack<String>> result;
	
	private static void dfs(String[][] tickets, boolean[] visit, Stack<String> stack, int index) {
		if(index==tickets.length) {
			Stack<String> temp = new Stack<>();
			temp.addAll(stack);
			result.add(temp);
			return;
		}
		
		String arrive = stack.peek();
		
		for(int i=0; i<tickets.length; i++) {
			if(visit[i]) continue;
			
			if(arrive.equals(tickets[i][0])) {
				stack.push(tickets[i][1]);
				visit[i] = true;
				
				dfs(tickets, visit, stack, index+1);
				
				visit[i] = false;
				stack.pop();
			}
		}
	}
}

