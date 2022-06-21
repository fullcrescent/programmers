package programmers.level3;

public class 징검다리_건너기 {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		int answer = solution(stones, k);
		System.out.println(answer);
	}
	
	public static int solution(int[] stones, int k) {
		int answer = 200000000;
		
		for(int stone : stones) {
			if(stone>answer) continue;
			
			int temp = 0;
			
			for(int tempStone : stones) {
				if(tempStone>stone) {
					temp = 0;
				}else {
					temp++;
					if(temp==k) {
						answer = stone;
						break;
					}
				}
			}
		}
		
		return answer;
	}
}
