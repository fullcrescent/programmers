package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int answer = solution(maps);
		System.out.println(answer);
		
		int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int answer1 = solution1(maps1);
		System.out.println(answer1);
	}

	public static int solution(int[][] maps) {
		sum = new int[maps.length][maps[0].length];
		findLoad(maps, 0, 0, 0);
		return min;
	}
	
	static int min = -1;
	static int[][] sum;
	
	private static void findLoad(int[][] maps, int x, int y, int count) {
		count++;
		if(count == min) return ;
		if(x==maps.length-1 && y==maps[0].length-1) {
			if(min == -1) min = count;
			min = Math.min(min,count);
			return;
		}
		
		if(x+1 != maps.length && maps[x+1][y] == 1) {
			if(sum[x+1][y]==0 || sum[x+1][y] > count) {
				sum[x+1][y] = count;
				findLoad(maps, x+1, y, count);
			}
		}
		
		if(y+1 != maps[0].length && maps[x][y+1] == 1) {
			if(sum[x][y+1]==0 || sum[x][y+1] > count) {
				sum[x][y+1] = count;
				findLoad(maps, x, y+1, count);
			}
		}
		
		if(x-1 > -1 && maps[x-1][y] == 1) {
			if(sum[x-1][y]==0 || sum[x-1][y] > count) {
				sum[x-1][y] = count;
				findLoad(maps, x-1, y, count);
			}
		}
		
		if(y-1 > -1 && maps[x][y-1] == 1) {
			if(sum[x][y-1]==0 || sum[x][y-1] > count) {
				sum[x][y-1] = count;
				findLoad(maps, x, y-1, count);
			}
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[][] maps) {
		int[][] visit = new int[maps.length][maps[0].length];
		visit[0][0]=1;
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(0,0));
		
		int[] dx= {0, 0, 1, -1}; 
		int[] dy= {1, -1, 0, 0};
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(int i=0; i<dx.length; i++) {
				int x=point.x+dx[i];
				int y=point.y+dy[i];
				
				if(x>=0 && x<maps.length && y>=0 && y<maps[0].length) {
					if(maps[x][y]==1 && visit[x][y]==0) {
						queue.add(new Point(x,y));
						visit[x][y]=visit[point.x][point.y]+1;
					}
				}
			}
		}
		
		return visit[maps.length-1][maps[0].length-1]>0 ? visit[maps.length-1][maps[0].length-1] : -1;
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
