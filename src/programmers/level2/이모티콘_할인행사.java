package programmers.level2;

import java.util.Arrays;

public class 이모티콘_할인행사 {
    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] answer = solution(users, emoticons);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] discount = {10, 20, 30, 40};
        int count = 0;

        boolean[] subscription = new boolean[users.length];
        int sum = Arrays.stream(emoticons).sum();

        for(int i=0; i< users.length; i++){
            subscription[i] = users[i][1] < (100-Math.ceil(users[i][0]/10)*10) * sum/100;
        }


        return null;
    }
}
