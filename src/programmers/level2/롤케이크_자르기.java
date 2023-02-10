package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 롤케이크_자르기 {
    public static void main(String[] args){
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = solution(topping);
        System.out.println(answer);
    }

    public static int solution(int[] topping) {
        int count = 0;

        Loop:
        for(int i=0; i<topping.length; i++){
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for(int j=0; j<i+1; j++){
                set1.add(topping[j]);
            }

            for(int j=i+1; j<topping.length; j++){
                if(set1.size()<set2.size()) continue Loop;

                set2.add(topping[j]);
            }

            if(set1.size()==set2.size()) count++;
        }

        return count;
    }
}
