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
		
		int n1 = 5;
		int[][] results1 = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int answer1 = solution1(n1, results1);
		System.out.println(answer1);
	}
	
	public static int solution(int n, int[][] results) {
		int answer = 0;
		Map<Integer, List<Integer>> winMap = new HashMap<>();
		Map<Integer, List<Integer>> loseMap = new HashMap<>();
		
		for(int[] temp : results) {
			List<Integer> tempList = winMap.getOrDefault(temp[0], new ArrayList<>());
			tempList.add(temp[1]);
			winMap.put(temp[0], tempList);
			
			tempList = loseMap.getOrDefault(temp[1], new ArrayList<>());
			tempList.add(temp[0]);
			loseMap.put(temp[1], tempList);
		}
		
		for(int i=1; i<n+1; i++) {
			boolean[] visit = new boolean[n+1];
			visit[i] = true;
			
			
			find(winMap, i, visit);
			find(loseMap, i, visit);
			
			boolean flag = true;
			
			for(int k=1; k<n+1; k++) {
				if(!visit[k]) {
					flag = false;
					break;
				}
			}
			
			if(flag) answer++;
		}
		
		return answer;
	}

	private static void find(Map<Integer, List<Integer>> map, int i, boolean[] visit) {
		List<Integer> tempList = new ArrayList<>();
		
		for(int temp : map.getOrDefault(i, new ArrayList<>())) {
			tempList.add(temp);
		}
		
		int index = 0;
		
		while(!tempList.isEmpty() && index<tempList.size()) {
			int temp = tempList.get(index++);
			
			if(visit[temp]) continue;
			
			visit[temp] = true;
			if(map.get(temp)!=null) {
				tempList.addAll(map.get(temp));
			}
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int n, int[][] results) {
		int answer = 0;
		
		boolean[][] visit = new boolean[n+1][n+1];
		
		for(int[] temp : results) {
			visit[temp[0]][temp[1]] = true;
		}
		
		for(int link=1; link<n+1; link++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(i==j) continue;
					if(visit[i][link] && visit[link][j]) visit[i][j] =true;
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			boolean flag = true;
			
			for(int j=1; j<n+1; j++) {
				if(i==j) continue;
				
				if(!(visit[i][j] || visit[j][i])) {
					flag = false;
					break;
				}
			}
			
			if(flag) answer++;
		}
		
		return answer;
	}
}
