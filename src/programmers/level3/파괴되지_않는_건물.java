package programmers.level3;

import java.util.Arrays;

public class 파괴되지_않는_건물 {
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        int answer = solution(board, skill);
        System.out.println(answer);
    }

    public static int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int column = board[0].length+1;

        int[][] sum = new int[row+1][column+1];

        for(int[] temp : skill){
            int x1=temp[1], y1=temp[2], x2=temp[3], y2=temp[4], value=temp[5];

            if(temp[0]==1) value*=-1;

            sum[x1][y1] = value;
            sum[x1][y2+1] = -value;
            sum[x2+1][y1] = -value;
            sum[x2+1][y2+1] = value;
        }

        for(int i=0; i<row; i++){
            for(int j=1; j<column; j++){
                sum[i][j] += sum[i][j-1];
            }
        }

        for(int i=0; i<column; i++){
            for(int j=1; j<row; j++){
                sum[j][i] += sum[j-1][i];
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] += sum[i][j];
            }
        }

        return (int) Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i>=0)
                .count();
    }
}
