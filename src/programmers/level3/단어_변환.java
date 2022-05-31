package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		int answer = solution(begin, target, words);
		System.out.println(answer);
	}
	
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;

		boolean[] visit = new boolean[words.length];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(begin, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<words.length; i++) {
				if(visit[i]) continue;
				
				int tempCount = 0;
				for(int j=0; j<words[i].length(); j++) {
					if(words[i].charAt(j)==node.s.charAt(j)) tempCount++;
				}
				
				if(tempCount==words[i].length()-1) {
					if(words[i].equals(target)) {
						return node.count+1;
					}
					
					queue.add(new Node(words[i], node.count+1));
					visit[i] = true;
				}
			}
			
		}
		
		return answer;
	}
	
	static class Node{
		String s;
		int count;
		
		public Node(String s, int count) {
			this.s = s;
			this.count = count;
		}
	}
}
