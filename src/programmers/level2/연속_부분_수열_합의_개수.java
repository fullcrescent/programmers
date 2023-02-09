package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
    public static void main(String[] args){
        int[] elements = {7,9,1,1,4};
        int answer = solution(elements);
        System.out.println(answer);
    }

    public static int solution(int[] elements) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<2*elements.length; i++){
            list.add(elements[i%elements.length]);
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<elements.length-1; i++){
            for(int j=0; j<elements.length; j++){
                int temp = 0;

                for(int k=j; k<=j+i; k++){
                    temp += list.get(k);
                }

                set.add(temp);
            }
        }

        return set.size()+1;
    }
}
