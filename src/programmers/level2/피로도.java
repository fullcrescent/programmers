package programmers.level2;

public class 피로도 {

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		int answer = solution(k, dungeons);
		System.out.println(answer);
	}
	
	public static int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        
        for(int i=0; i<dungeons.length; i++) {
        	visit[i]=true;
        	adventure(k, dungeons, visit, i, 0);
        	visit[i]=false;
        }
        
        return max;
    }

	static int max=0;

	private static void adventure(int k, int[][] dungeons, boolean[] visit, int index, int count) {
		if(k>=dungeons[index][0]) {
			k -= dungeons[index][1];
			count++;
		}else {
			max = Math.max(max, count);
			return ;
		}
		
		if(count==visit.length) {
			max = count;
			return;
		}
		
		for(int i=0; i<visit.length; i++) {
			if(visit[i]) continue;
			visit[i]=true;
			adventure(k, dungeons, visit, i, count);
			visit[i]=false;
		}
	}
}
