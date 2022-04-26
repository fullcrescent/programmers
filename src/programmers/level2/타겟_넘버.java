package programmers.level2;

public class 타겟_넘버 {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		int answer = solution(numbers, target);
		System.out.println(answer);
		
		int[] numbers1 = {1, 1, 1, 1, 1};
		int target1 = 3;
		int answer1 = solution1(numbers, target);
		System.out.println(answer);
	}
	
	public static int solution(int[] numbers, int target) {
		dfs(numbers, 0, 0, target);
		return count;
	}
	
	static int count = 0;

	private static void dfs(int[] numbers, int index, int sum, int target) {
		if(index<numbers.length) {
			index++;
			dfs(numbers, index, sum+numbers[index-1], target);
			dfs(numbers, index, sum-numbers[index-1], target);
		}else {
			if(sum==target) {
				count++;
			}
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[] numbers, int target) {
		return dfs1(numbers, 0, 0, target);
	}

	private static int dfs1(int[] numbers, int index, int sum, int target) {
		if(index==numbers.length) {
			if(sum==target) return 1;
			return 0;
		}
		return dfs1(numbers, index+1, sum+numbers[index], target) + dfs1(numbers, index+1, sum-numbers[index], target);
	}
	
}
