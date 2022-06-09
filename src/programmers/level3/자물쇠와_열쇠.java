package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 자물쇠와_열쇠 {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		boolean answer = solution(key, lock);
		System.out.println(answer);
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;
		
		List<Point> list = new ArrayList<>();
		
		int tempX = -1;
		int tempY = -1;
		
		for(int i=0; i<key.length; i++) {
			for(int j=0; j<key.length; j++) {
				if(key[i][j]==1) {
					list.add(new Point(i-tempX, j-tempY));
					tempX = i;
					tempY = j;
				}
			}
		}
		
		list.remove(0);
		
		
        return answer;
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
