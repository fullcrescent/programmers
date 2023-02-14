package programmers.level2;

import java.util.*;

public class 두_큐_합_같게_만들기 {

	public static void main(String[] args) {
		int[] queue1 = {24, 12};
		int[] queue2 = {24, 12};
		int answer = solution(queue1, queue2);
		System.out.println(answer);

		int[] queue1_1 = {24, 12};
		int[] queue2_1 = {24, 12};
		int answer1 = solution1(queue1_1, queue2_1);
		System.out.println(answer1);
	}

	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		
		List<Long> list1 = new ArrayList<>();
		List<Long> list2 = new ArrayList<>();

		for(int i=0; i<queue1.length; i++){
			list1.add((long) queue1[i]);
			list2.add((long) queue2[i]);
		}

		long sum1 = Arrays.stream(queue1).sum();
		long sum2 = Arrays.stream(queue2).sum();

		if(sum1==sum2)  return 0;

		int index1 = 0;
		int index2 = 0;
		
		if((sum1+sum2)%2==0) {
			
			while(answer<2*(queue1.length+queue2.length)) {
				answer++;
				Long add;
				if(sum1>sum2) {
					add = list1.get(index1);
					list2.add(add);
					sum1 -= add;
					sum2 += add;
					index1++;
				}else {
					add = list2.get(index2);
					list1.add(add);
					sum1 += add;
					sum2 -= add;
					index2++;
				}
				
				if(sum1==sum2) break;
				
				if(sum1==0 || sum2==0) return 0;
			}
			
			return answer==2*(queue1.length+queue2.length) ? -1 : answer;
		}else {
			return -1;
		}
	}

	/*다른 사람의 풀이 참고*/
	private static int solution1(int[] queue1, int[] queue2) {
		int answer = 0;

		Queue<Integer> q1 = new LinkedList<>(Arrays.asList(Arrays.stream(queue1).boxed().toArray(Integer[]::new)));
		Queue<Integer> q2 = new LinkedList<>(Arrays.asList(Arrays.stream(queue2).boxed().toArray(Integer[]::new)));

		long sum1 = q1.stream().mapToLong(i -> i).sum();
		long sum2 = q2.stream().mapToLong(i -> i).sum();

		if(sum1==sum2)	return 0;
		else if((sum1+sum2)%2==1)	return -1;

		while(answer<2*(queue1.length+queue2.length)){
			if(q1.isEmpty() || q2.isEmpty()) break;
			answer++;

			if(sum1>sum2){
				Integer temp = q1.poll();
				q2.add(temp);
				sum1 -= temp;
				sum2 += temp;
			}else{
				Integer temp = q2.poll();
				q1.add(temp);
				sum1 += temp;
				sum2 -= temp;
			}

			if(sum1==sum2) break;
		}

		return answer==2*(queue1.length+queue2.length) ? -1 : answer;
	}
}