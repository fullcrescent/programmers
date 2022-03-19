package programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 방문_길이 {

	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		int answer = solution(dirs);
		System.out.println(answer);
		
		String dirs1 = "LULLLLLLU";
		int answer1 = solution1(dirs1);
		System.out.println(answer1);
	}

	public static int solution(String dirs) {
		List<Segment> list = new LinkedList<>();
		
		int answer = 0;
		
		int x = 0;
		int y = 0;
		
		Loop1 : 
		for(int i=0; i<dirs.length(); i++) {
			int moveX = x;
			int moveY = y;
			if(dirs.charAt(i)=='U' && moveY<5) {
				moveY++;
			}else if(dirs.charAt(i)=='D'&& moveY>-5) {
				moveY--;
			}else if(dirs.charAt(i)=='R' && moveX<5) {
				moveX++;
			}else if(dirs.charAt(i)=='L' && moveX>-5) {
				moveX--;
			}else {
				continue;
			}
			
			for(Segment temp : list) {
				if((temp.x1==x && temp.y1==y && temp.x2 == moveX && temp.y2==moveY) 
						||(temp.x1==moveX && temp.y1==moveY && temp.x2 == x && temp.y2==y)) {
					x = moveX;
					y = moveY;
					continue Loop1;
				}
			}
			
			list.add(new Segment(x, y, moveX, moveY));
			answer++;
			x = moveX;
			y = moveY;
		}
		
		return answer;
	}
	
	
	static class Segment{
		int x1, x2;
		int y1, y2;
		
		public Segment(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(String dirs) {
		Map<Character, int[]> map = new HashMap<>();
		map.put('U', new int[] {0, 1});
		map.put('D', new int[] {0, -1});
		map.put('L', new int[] {-1, 0});
		map.put('R', new int[] {1, 0});
		
		int x = 0;
		int y = 0;
		
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<dirs.length(); i++) {
			char temp = dirs.charAt(i);
			
			String s1 = x+""+y;
			
			x += map.get(temp)[0];
			y += map.get(temp)[1];
			
			if(x<-5 || x>5) {
				x -= map.get(dirs.charAt(i))[0];
				continue;
			}
			if(y<-5 || y>5) {
				y -= map.get(dirs.charAt(i))[1];
				continue;
			}
			
			String s2 = x+""+y;
			
			set.add(s1+s2);
			set.add(s2+s1);
		}
		
		return set.size()/2;
	}
}

