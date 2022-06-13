package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 불량_사용자 {

	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		int answer = solution(user_id, banned_id);
		System.out.println(answer);
		
		String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id1 = {"*rodo", "*rodo", "******"};
		int answer1 = solution1(user_id1, banned_id1);
		System.out.println(answer1);
	}
	
	public static int solution(String[] user_id, String[] banned_id) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		int index = 0;
		
		for(String banned : banned_id) {
			List<Integer> temp = new ArrayList<>();

			Loop1:
			for(int i=0; i<user_id.length; i++) {
				if(banned.length()!=user_id[i].length()) {
					continue;
				}
				
				for(int j=0; j<banned.length(); j++) {
					if(banned.charAt(j)!='*'&&banned.charAt(j)!=user_id[i].charAt(j)) {
						continue Loop1;
					}
				}
				
				temp.add(i);
			}
			
			map.put(index++, temp);
		}
		
		boolean[] visit = new boolean[user_id.length];
		
		validate(map, visit, 0, map.size());
		
		return answer.size();
	}
	
	static Set<String> answer = new HashSet<>();
	
	private static void validate(Map<Integer, List<Integer>> map, boolean[] visit, int start, int end) {
		if(start==end) {
			String temp = "";
			for(int i=0; i<visit.length; i++) {
				if(visit[i]) {
					temp += i + "/"; 
				}
			}
			
			answer.add(temp);
			
			return;
		}
		
		for(int temp : map.get(start)) {
			if(visit[temp]) continue;
			
			visit[temp] = true;
			validate(map, visit, start+1, end);
			visit[temp] = false;
		}		
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(String[] user_id, String[] banned_id) {
		set = new HashSet<>();
		validate1(0, user_id, banned_id, 0);
		
		return set.size();
	}
	
	static Set<Integer> set;

	private static void validate1(int index, String[] user_id, String[] banned_id, int bit) {
		if(index==banned_id.length) {
			set.add(bit);
			return;
		}
		
		String regex = banned_id[index].replace("*", "[\\w\\d]");
		
		for(int i=0; i<user_id.length; i++) {
			if((((bit>>i)&1)==1) || !user_id[i].matches(regex)) continue;
			
			validate1(index+1, user_id, banned_id, (bit|1<<i));
		}
	}
}
