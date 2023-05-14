package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class 우박수열_정적분 {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
        double[] answer = solution(k, ranges);
        System.out.println(Arrays.toString(answer));
    }

    public static double[] solution(double k, int[][] ranges) {
        Map<Integer, Double> map = new HashMap<>();
        int index = 0;

        while(k>1){
            double temp;

            if(k%2==0){
                temp = k/2;
            }else{
                temp = k*3 +1;
            }

            map.put(index++, (k+temp)/2);
            k = temp;
        }

        int end = index;

        return Arrays.stream(ranges)
                .mapToDouble(range -> {
                    if(end+range[1]<range[0])   return -1.0;

                    return IntStream.range(range[0], end+range[1])
                            .mapToDouble(map::get)
                            .sum();
                })
                .toArray();
    }
}
