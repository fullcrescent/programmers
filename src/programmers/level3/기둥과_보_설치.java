package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기둥과_보_설치 {

	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] answer = solution(n, build_frame);
		for(int[] temp : answer) {
			System.out.println(Arrays.toString(temp));
		}
	}
	
	public static int[][] solution(int n, int[][] build_frame) {
		int[][] answer;
		List<Point> addList = new ArrayList<>();
		List<Point> answerList = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			addList.add(new Point(i, 0, 0));
		}
		
		for(int[] temp : build_frame) {
			Point point = new Point(temp[0], temp[1], temp[2]);
			
			/* 삭제 */
			if(temp[3]==0) {
				if(point.type==0) {
					if((answerList.contains(new Point(point.x, point.y+1, 0))
							&& (!answerList.contains(new Point(point.x-1, point.y+1, 1))
								&& !answerList.contains(new Point(point.x, point.y+1, 1))))
						|| (answerList.contains(new Point(point.x, point.y+1, 1)) 
							&& (!answerList.contains(new Point(point.x+1, point.y, 0))
								&& (!answerList.contains(new Point(point.x-1, point.y+1, 1)) 
									&&!answerList.contains(new Point(point.x+1, point.y+1, 1)))) )
						|| (answerList.contains(new Point(point.x-1, point.y+1, 1))
							&& (!answerList.contains(new Point(point.x-1, point.y, 0))
								|| (!answerList.contains(new Point(point.x, point.y+1, 1))
									&&!answerList.contains(new Point(point.x-2, point.y+1, 1)))))){
						continue;
					}else {
						answerList.remove(point);
						addList.remove(new Point(point.x-1, point.y+1, 1));
						addList.remove(new Point(point.x, point.y+1, 1));
						addList.remove(new Point(point.x, point.y+1, 0));
					}
				}else if(point.type==1) {
					if((answerList.contains(new Point(point.x, point.y, 0))
							&& (!answerList.contains(new Point(point.x, point.y-1, 0))
								|| !answerList.contains(new Point(point.x-1, point.y, 1))))
						|| (answerList.contains(new Point(point.x+1, point.y, 0))
							&& (!answerList.contains(new Point(point.x+1, point.y-1, 0))
								|| !answerList.contains(new Point(point.x+1, point.y, 1))))
						|| (answerList.contains(new Point(point.x-1, point.y, 1))
							&& (!answerList.contains(new Point(point.x-1, point.y-1, 0))
								|| !answerList.contains(new Point(point.x, point.y-1, 0))))
						|| (answerList.contains(new Point(point.x+1, point.y, 1))
							&& (!answerList.contains(new Point(point.x+1, point.y-1, 0))
								|| !answerList.contains(new Point(point.x+2, point.y-1, 0))))) {
						continue;
					}else {
						answerList.remove(point);
						addList.remove(new Point(point.x+1, point.y, 0));
						addList.remove(new Point(point.x+1, point.y, 1));
						addList.remove(new Point(point.x-1, point.y, 1));
					}
				}
			}
			/* 추가 */
			else if(temp[3]==1) {
				if(addList.contains(point)) {
					answerList.add(point);
					
					if(point.type==0) {
						addList.add(new Point(point.x-1, point.y+1, 1));
						addList.add(new Point(point.x, point.y+1, 1));
						addList.add(new Point(point.x, point.y+1, 0));
					}else if(point.type==1){
						addList.add(new Point(point.x+1, point.y, 0));
						if(answerList.contains(new Point(point.x+2, point.y, 1))) {
							addList.add(new Point(point.x+1, point.y, 1));
						}
						if(answerList.contains(new Point(point.x-2, point.y, 1))) {
							addList.add(new Point(point.x-1, point.y, 1));
						}
					}
				}
			}
		}
		
		answer = new int[answerList.size()][3];
		
		answerList.sort((o1, o2) -> {
			if(o1.x==o2.x) {
				return Integer.compare(o1.y, o2.y);
			}else {
				return Integer.compare(o1.x, o2.x);
			}
		});
		
		int index = 0;
		
		for(Point temp : answerList) {
			answer[index][0] = temp.x;
			answer[index][1] = temp.y;
			answer[index++][2] = temp.type;
		}
		
		return answer;
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
