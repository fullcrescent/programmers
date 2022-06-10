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
		int[][] tempArray1 = key.clone();
		int[][] tempArray2 = new int[key.length][key.length];
		
		Loop1 : 
		for(int r=0; r<4; r++) {
			for(int i=0; i<tempArray1.length; i++) {
				for(int j=0; j<tempArray1[i].length; j++) {
					tempArray2[i][j] = tempArray1[tempArray1.length-1-j][i];
				}
			}
			
			tempArray1 = tempArray2.clone();
			
			List<Point> list = new ArrayList<>();

			int tempX = -1;
			int tempY = -1;

			for(int i=0; i<tempArray2.length; i++) {
				for(int j=0; j<tempArray2.length; j++) {
					if(tempArray2[i][j]==1) {
						list.add(new Point(i-tempX, j-tempY));
						tempX = i;
						tempY = j;
					}
				}
			}
			
			list.remove(0);
			
			int lockX = -1;
			int lockY = -1;
			
			boolean flag = true;
			
			for(int i=0; i<lock.length; i++) {
				for(int j=0; j<lock.length; j++) {
					if(lock[i][j]==0) {
						if(lockX==-1) {
							lockX = i;
							lockY = j;
						}else {
							Point temp = list.get(0);
							
							if(i-lockX==temp.x&&j-lockY==temp.y) {
								list.remove(0);
							}else {
								if(flag) continue Loop1;
							}
						}
					}
				}
			}
			
			return true;
		}
		
		return false;
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
