package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 빛의_경로_사이클 {

	public static void main(String[] args) {
		String[] grid = {"SL","LR"};
		int[] answer = solution(grid);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String[] grid) {
		Map<String, Boolean> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		
		int count = 0;
		int sum =0;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length(); j++) {
				for(int k=0; k<4; k++) {
					map.put(String.valueOf(i)+String.valueOf(j)+String.valueOf(k), false);	// 나가는 배열 : 동서남북
					count++;
				}
			}
		}
		
		Loop1:
		while(count!=sum) {
			for(int i=0; i<grid.length; i++) {
				for(int j=0; j<grid[i].length(); j++) {
					for(int k=0; k<4; k++) {
						String key = String.valueOf(i)+String.valueOf(j)+String.valueOf(k);
						if(!map.get(key)) {
							int value = cycle(map, grid, key);
							list.add(value);
							sum += value;
							continue Loop1;
						}
					}
				}
			}
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray(); 
	}

	private static int cycle(Map<String, Boolean> map, String[] grid, String key) {
		char[] left = {2, 3, 1, 0};
		char[] right = {3, 2, 0, 1};
		
		int count = 0;
		
		while(!map.get(key)) {
			count++;
			map.put(key, true);
			
			int x = Integer.valueOf(key.substring(0, 1));
			int y = Integer.valueOf(key.substring(1, 2));
			int z = Integer.valueOf(key.substring(2));
			
			if(z==0) {
				if(y==0) {
					y = grid[x].length()-1;
				}else {
					y--;
				}
			}else if(z==1) {
				if(y==grid[x].length()-1) {
					y = 0;
				}else {
					y++;
				}
			}else if(z==2) {
				if(x==grid.length-1) {
					x = 0;
				}else {
					x++;
				}
			}else if(z==3) {
				if(x==0) {
					x = grid.length-1;
				}else {
					x--;
				}
			}
			
			char temp = grid[x].charAt(y);
			
			if(temp=='L') {
				z = left[z];
			}else if(temp=='R') {
				z = right[z];
			}
			
			key = "" + x + y + z;
		}
		
		return count;
	}
}
