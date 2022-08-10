package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기둥과_보_설치 {

	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] answer = solution(n, build_frame);
		for(int[] temp : answer) {
			System.out.println(Arrays.toString(temp));
		}
	}
	
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	
	public static int[][] solution(int n, int[][] build_frame) {
		List<Point> addList = new ArrayList<>();
		List<Point> answerList = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			addList.add(new Point(i, 0, 0));
		}
		
		for(int[] temp : build_frame) {
			Point point = new Point(temp[0], temp[1], temp[2]);
			
			/* 삭제 */
			if(temp[3]==0) {
				
			}
			/* 추가 */
			else if(temp[3]==1) {
				if(addList.contains(point)) {
					answerList.add(point);
					addList.remove(point);
					
					if(point.type==0) {
						addList.add(new Point(point.x-1, point.y+1, 0));
						addList.add(new Point(point.x, point.y+1, 0));
						addList.add(new Point(point.x, point.y+1, 1));
					}else {
						
					}
					
					
				}else {
					System.out.println("b");
				}
			}
		}
		
		
		
			
		return null;
	}

	public static class Point{
		int x;
		int y;
		int type;
		
		public Point(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
		
		public boolean equals(Object point) {
			Point temp = (Point) point;
			return this.x==temp.x && this.y==temp.y && this.type==temp.type;
		}
	}
}
