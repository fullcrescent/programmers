package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class 영어_끝말잇기 {

	public static void main(String[] args) {
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		int[] answer = solution(n, words);
		System.out.println(Arrays.toString(answer));
		
		int n1 = 2;
		String[] words1 = {"hello", "one", "even", "never", "now", "world", "draw"};
		int[] answer1 = solution1(n1, words1);
		System.out.println(Arrays.toString(answer1));
		
		int n2 = 3;
		String[] words2 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] answer2 = solution2(n2, words2);
		System.out.println(Arrays.toString(answer2));
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
	
	// 효율이 위에가 더 좋음
	public static int[] solution1(int n, String[] words) {
		int[] answer = new int[2];
		
		Queue<String> queue = new PriorityQueue<>();
		
        for(int i=0; i<words.length-1; i++) {
        	String prev = words[i];
        	String next = words[i+1];
        	
        	if(queue.contains(next) || !next.startsWith(prev.substring(prev.length()-1))) {
        		answer[0] = (i+1)%n+1;
        		answer[1] = (i+1)/n+1;
        		break;
        	}
        	
        	queue.add(prev);
        }
        
        return answer;
    }
	
	// 다른 사람의 풀이 참고 
	public static int[] solution2(int n, String[] words) {
		int[] answer = new int[2];
		
		Set<String> set = new HashSet<>();
		set.add(words[0]);
		
        for(int i=0; i<words.length-1; i++) {
        	String prev = words[i];
        	String next = words[i+1];
        	
        	set.add(next);
        	
        	if(!next.startsWith(prev.substring(prev.length()-1)) || set.size()!=i+2) {
        		answer[0] = (i+1)%n+1;
        		answer[1] = (i+1)/n+1;
        		break;
        	}
        }
        
        return answer;
    }
	
}
