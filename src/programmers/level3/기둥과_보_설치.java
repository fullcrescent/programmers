package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기둥과_보_설치 {

	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] answer = solution(n, build_frame);
		Arrays.stream(answer).forEach(i -> System.out.println(Arrays.toString(i)));
	}
	
	public static int[][] solution(int n, int[][] build_frame) {
		Point[][] array = new Point[n][n];

		for(int[] temp : build_frame){
			int x = temp[0];
			int y = temp[1];

			Point point = array[x][y];

			if(temp[3]==0){				// 삭제
				if(temp[2]==0){			// 기둥

				}else if(temp[2]==1){	// 보

				}
			}
			else if(temp[3]==1){		// 설치
				if(temp[2]==0){			// 기둥
					if(y==0 || (point!=null && point.beamCount==1) || (point!=null && point.columnCount==1)){
						if(array[x][y+1]==null){
							array[x][y+1] = new Point(x, y+1);
							array[x][y+1].columnCount = 1;
						}
					}
				}else if(temp[2]==1){	// 보

				}
			}

		}

		return new int[0][0];
	}

	public static class Point{
		int x;
		int y;
		int columnCount;
		int beamCount;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
