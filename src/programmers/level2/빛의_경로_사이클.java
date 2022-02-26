package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 빛의_경로_사이클 {

	public static void main(String[] args) {
		String[] grid = {"S"};
		int[] answer = solution(grid);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String[] grid) {
		Map<String, Boolean> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length(); j++) {
				for(int k=0; k<4; k++) {
					map.put(i + "|" + j + "|" + k, false);	// 나가는 배열 : 동서남북
				}
			}
		}
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length(); j++) {
				for(int k=0; k<4; k++) {
					String key = i + "|" + j + "|" + k;
					if(!map.get(key)) {
						list.add(cycle(map, grid, i, j, k));
					}
				}
			}
		}
		
		list.sort(null);
		return list.stream().mapToInt(i->i).toArray(); 
	}

	private static int cycle(Map<String, Boolean> map, String[] grid, int i, int j, int k) {
		char[] left = {2, 3, 1, 0};
		char[] right = {3, 2, 0, 1};
		
		int count = 0;
		
		String key = i + "|" + j + "|" + k;
		
		while(!map.get(key)) {
			count++;
			map.put(key, true);
			
			if(k==0) {
				if(j==0) {
					j = grid[i].length()-1;
				}else {
					j--;
				}
			}else if(k==1) {
				if(j==grid[i].length()-1) {
					j = 0;
				}else {
					j++;
				}
			}else if(k==2) {
				if(i==grid.length-1) {
					i = 0;
				}else {
					i++;
				}
			}else if(k==3) {
				if(i==0) {
					i = grid.length-1;
				}else {
					i--;
				}
			}
			
			char temp = grid[i].charAt(j);
			
			if(temp=='L') {
				k = left[k];
			}else if(temp=='R') {
				k = right[k];
			}
			
			key = i + "|" + j + "|" + k;
		}
		
		return count;
	}
}
