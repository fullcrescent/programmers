package programmers.level2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 테이블_해시_함수 {
    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int answer = solution(data, col, row_begin, row_end);
        System.out.println(answer);

        int[][] data1 = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col1 = 2;
        int row_begin1 = 2;
        int row_end1 = 3;
        int answer1 = solution1(data1, col1, row_begin1, row_end1);
        System.out.println(answer1
        );
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (i1, i2) -> {
            if(i1[col-1]==i2[col-1]){
                return -Integer.compare(i1[0], i2[0]);
            }

            return Integer.compare(i1[col-1], i2[col-1]);
        });

        return IntStream.range(row_begin-1, row_end)
                .map(i -> IntStream.range(0, data[i].length)
                        .map(j -> data[i][j]%(i+1))
                        .sum())
                .reduce((i1, i2) -> i1^i2)
                .getAsInt();
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (i1, i2) -> i1[col-1]==i2[col-1] ? i2[0]-i1[0] : i1[col-1]-i2[col-1]);

        return IntStream.range(row_begin-1, row_end)
                .map(i -> Arrays.stream(data[i])
                        .map(k -> k % (i + 1))
                        .sum())
                .reduce((i1, i2) -> i1^i2)
                .orElse(0);
    }
}
