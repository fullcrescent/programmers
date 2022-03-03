package programmers.level2;

public class 타겟_넘버 {

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		int answer = solution(numbers, target);
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
}
