package programmers.level3;

public class 고고학_최고의_발견 {
    public static void main(String[] args){
        int[][] clockHands = {{0,3,3,0},{3,2,2,3},{0,3,2,0},{0,3,3,3}};
        int answer = solution(clockHands);
        System.out.println(answer);
    }

    public static int solution(int[][] clockHands) {
        int[][] count = new int[clockHands.length][clockHands[0].length];

        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i=0; i<clockHands.length; i++){
            for(int j=0; j<clockHands[i].length; j++){
                if(clockHands[i][j]>0){
                    for(int[] temp : d){
                        if(-1<i+temp[0] && i+temp[0]<clockHands.length && -1<j+temp[1] && j+temp[1]<clockHands[i].length){
                            count[i+temp[0]][j+temp[1]] += 4-clockHands[i][j];
                        }
                    }
                }
            }
        }

        return 1;
    }
}