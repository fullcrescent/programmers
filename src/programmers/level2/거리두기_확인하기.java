package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {
	public static void main(String args[]) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = solution(places);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
		System.out.println(answer[3]);
		System.out.println(answer[4]);
	}

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
