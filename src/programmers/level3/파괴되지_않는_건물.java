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
        int row = board.length;
        int column = board[0].length;

        int[] temp = new int[row*column];

        for(int i=0; i<row; i++){
            System.arraycopy(board[i], 0, temp, i * column, column);
        }

        Arrays.stream(skills)
                .forEach(skill -> {
                    int add = skill[0]==1 ? -skill[5] : skill[5];

                    for(int a=skill[1]; a<=skill[3]; a++){
                        for(int b=skill[2]; b<=skill[4]; b++){
                            temp[a*column + b] += add;
                        }
                    }
                });

        return (int) Arrays.stream(temp)
                .filter(i -> i>0)
                .count();
    }
}
