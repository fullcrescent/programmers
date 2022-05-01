package programmers.level2;

import java.util.ArrayList;
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
		
		String[] grid1 = {"S"};
		int[] answer1 = solution1(grid1);
		System.out.println(Arrays.toString(answer1));
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
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(String[] grid) {
		List<Integer> list = new ArrayList<>();
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		
		boolean[][][] visit = new boolean[grid.length][grid[0].length()][dx.length];
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length(); j++) {
				for(int k=0; k<dx.length; k++) {
					if(!visit[i][j][k]) {
						int x = i;
						int y = j;
						int dir = k;
						
						int count = 0;
						
						while(!visit[x][y][dir]) {
							visit[x][y][dir] = true;
							
							if(grid[x].charAt(y) == 'R')  dir++;
							if(grid[x].charAt(y) == 'L')  dir--;
							
							if(dir==4) dir=0;
							if(dir==-1) dir=3;
							
							x += dx[dir];
							y += dy[dir];
							
							if(x==-1) x = grid.length-1;
							if(x==grid.length) x = 0;
							
							if(y==-1) y = grid[x].length()-1;
							if(y==grid[x].length()) y = 0;
							
							count++;
						}
						list.add(count);
					}
				}
			}
		}
		
		list.sort(null);
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
