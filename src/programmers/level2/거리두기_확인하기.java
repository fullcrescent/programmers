package programmers.level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {
	public static void main(String args[]) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = solution1(places);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
		System.out.println(answer[3]);
		System.out.println(answer[4]);
	}
	
	public static int[] solution1(String[][] places) {
		int[] answer = new int[places.length];
		boolean[][] visit ;
		
		for (int i = 0, len = answer.length; i < len; i++)
			answer[i] = 1;
		
		Loop1 :
		for(int i=0; i<places.length; i++) {
			visit = new boolean[places.length][places.length];
			for(int j=0; j<places[i].length; j++) {
				for(int k=0; k<places[i][j].length(); k++) {
					if(places[i][j].charAt(k) == 'P') {
						visit[j][k] = true;
						if(dfs(answer, visit, places, i, j, k, 0, 2)) break Loop1;
						visit[j][k] = false;
					}
				}
			}
		}
		
		
		return answer;
	}
	
	static int[] dx1 = {-1, 0, 0, 1};
	static int[] dy1 = {0, -1, 1, 0};
	
	private static boolean dfs(int[] answer, boolean[][] visit, String[][] places, int i, int j, int k, int count, int distance) {
		if(count > 0 && places[i][j].charAt(k) == 'P') {
			answer[i] = 0;
			return true;
		}
		
		int nx;
		int ny;
		
		for(int index=0; index<dx1.length; index++) {
			nx = j + dx1[index];
			ny = k + dy1[index];
			
			if(nx >=0 && nx<places[i].length && ny >= 0 && ny<places[i][j].length() && places[i][nx].charAt(ny) != 'X') {
				if(visit[nx][ny]) continue;
				visit[nx][ny] = true;
				if(count < distance) dfs(answer, visit, places, i, nx, ny, count+1, distance) ;
				visit[nx][ny] = false;
			}
			
		}
		
		return false;
	}

	//	배열 크기 가변, 문자열 길이, 거리 값에서 자유로움 
	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for(int i=0; i<places.length; i++) {
			answer[i] = locationInfoSetting(places[i]);
		}
		
		return answer;
	}
	
	public static int locationInfoSetting(String[] places) {
		Queue<Point> queueP = new LinkedList<>();
		Queue<Point> queueO = new LinkedList<>();
		
		for(int i=0; i<places.length; i++) {
			for(int j=0; j<places[i].length() ; j++) {
				if(places[i].charAt(j) == 'P') {
					queueP.add(new Point(i,j));
				}else if(places[i].charAt(j) == 'O') {
					queueO.add(new Point(i,j));
				}
			}
		}

		while(!queueP.isEmpty()) {
			Point point = queueP.poll();
			if(verification(point, queueP,queueO, 2, 0)) {
				return 0;
			}
		}
		return 1;
	}
	
	
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	public static boolean verification(Point point, Queue<Point> queueP, Queue<Point> queueO, int distance, int count) {
		count++;
		for(int i=0; i<dx.length; i++) {
			Point newPoint = new Point(point.x+dx[i], point.y+dy[i]);
			if(belong(newPoint, queueP)) {
				return true;
			}
			if(belong(newPoint, queueO) && count < distance) {
				if(verification(newPoint, queueP, queueO, distance, count)) return true;
			}
		}
		return false;
	}
	
	public static boolean belong(Point point, Queue<Point> queue) {
		Iterator<Point> iterator = queue.iterator();
		while(iterator.hasNext()){
			Point queuePoint = iterator.next();
			if(point.x == queuePoint.x && point.y==queuePoint.y) {
				return true;
			}
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
