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
		Point[][] array = new Point[n+1][n+1];

		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				array[i][j]	= new Point();
			}
		}

		for(int[] build : build_frame){
			int x = build[0];
			int y = build[1];

			Point point1 = array[x][y];
			Point point2 = build[2]==0 ? array[x][y+1] : build[2]==1 ? array[x+1][y] : null;

			if(build[3]==0){				// 삭제
				if(build[2]==0){			// 기둥
					if((array[x][y+2].column &&!(point2.leftBeam^point2.rightBeam))
							|| (point2.leftBeam && !point2.rightBeam && array[x-1][y+1].column)
							|| (point2.rightBeam && !point2.leftBeam && array[x+1][y+1].column)
							|| (point2.leftBeam && point2.rightBeam && (array[x-1][y+1].column || array[x-1][y+1].leftBeam) && (array[x+1][y+1].column || array[x+1][y+1].leftBeam))){
						point2.column =false;
					}
				}else if(build[2]==1){	// 보
				}
			}
			else if(build[3]==1){		// 설치
				if(build[2]==0){			// 기둥
					if(y==0 || (point1.leftBeam^point1.rightBeam) || point1.column){
						point2.column = true;
					}
				}else if(build[2]==1){	// 보
					if(point1.column || point2.column || (point1.leftBeam && point2.rightBeam)){
						point1.rightBeam = true;
						point2.leftBeam = true;
					}
				}
			}

		}

		return new int[0][0];
	}

	public static class Point{
		boolean column;
		boolean leftBeam;
		boolean rightBeam;
	}
}
