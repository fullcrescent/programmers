package programmers.level3;

public class 자물쇠와_열쇠 {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		int[][] lock = {{0, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		boolean answer = solution(key, lock);
		System.out.println(answer);
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		int[][] tempKey = new int[key.length][key.length];
		
		for(int r=0; r<4; r++) {
			for(int i=0; i<key.length; i++) {
				for(int j=0; j<key.length; j++) {
					tempKey[i][j] = key[key.length-1-j][i];
				}
			}
			
			for(int i=0; i<key.length; i++) {
				for(int j=0; j<key.length; j++) {
					key[i][j] = tempKey[i][j];
				}
			}
			
			for(int x=-lock.length; x<lock.length; x++) {
				Loop1 : 
				for(int y=-lock.length; y<lock.length; y++) {
					int[][] tempLock = new int[lock.length][lock.length];
					
					for(int i=0; i<lock.length; i++) {
						for(int j=0; j<lock.length; j++) {
							tempLock[i][j] = lock[i][j];
						}
					}

					for(int i=0; i<tempLock.length; i++) {
						for(int j=0; j<tempLock.length; j++) {
							if(i-x>-1 && i-x<key.length && j-y>-1 && j-y<key.length) {
								tempLock[i][j] += tempKey[i-x][j-y];
							}
							
							if(tempLock[i][j]!=1) continue Loop1;
						}
					}
					
					return true;
				}
			}
		}
		
		return false;
	}
	
}
