package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 영어_끝말잇기 {

	public static void main(String[] args) {
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		int[] answer = solution(n, words);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		
        List<List<String>> list = new ArrayList<>();
		Queue<String> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
			list.add(new ArrayList<String>());
		}
        
        for(int i=0; i<words.length; i++) {
        	list.get(i%n).add(words[i]);
        }
		
        for(int i=0; i<words.length-1; i++) {
        	String prev = list.get(i%n).get(i/n);
        	String next = list.get((i+1)%n).get((i+1)/n);
        	
        	if(queue.contains(next) || !next.startsWith(prev.substring(prev.length()-1))) {
        		answer[0] = (i+1)%n+1;
        		answer[1] = (i+1)/n+1;
        		break;
        	}
        	
        	queue.add(prev);
        }
        
        return answer;
    }
}
