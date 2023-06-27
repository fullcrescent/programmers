package programmers.level3;

import java.util.Arrays;

public class 파괴되지_않는_건물 {
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        int answer = solution(board, skill);
        System.out.println(answer);
    }

    public static int solution(int[][] board, int[][] skills) {
        for(int[] skill : skills){
            if(skill[0]==1){
                function(board, skill[1], skill[2], skill[3], skill[4], -skill[5]);
            }else{
                function(board,skill[1], skill[2], skill[3], skill[4], skill[5]);
            }
        }

        return (int) Arrays.stream(board)
                .flatMapToInt(array -> Arrays.stream(array))
                .filter(i -> i>0)
                .count();
    }

    private static void function(int[][] board, int x1, int y1, int x2, int y2, int value) {
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                board[i][j] += value;
            }
        }
    }
}
