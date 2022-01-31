package programmers.level2;

import java.util.LinkedList;
import java.util.List;

public class 방문_길이 {

	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		int answer = solution(dirs);
		System.out.println(answer);
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
}

